package net.chris.experiment.investigatetask

import android.app.Activity
import android.content.Intent
import android.widget.CheckBox
import android.widget.RadioButton

fun Activity.handle(): Intent {
  val special = "${this::class.java.simpleName} : ${
    System.currentTimeMillis().toString().let { it.substring(it.length - 6) }
  }"
  val dest = getDestination()
  println("############ from: $special to ${dest.simpleName}")
  var flags = 0
  for (id in map.keys) {
    val flag = getFlag(this, id)
    if (flag != 0) println("flag: ${names[flag]}")
    flags = flags or flag
  }
  return Intent(this, dest).apply {
    this.flags = flags
    putExtra(SPECIAL_EXTRA, special)
    println("############")
    println("")
  }
}

private fun getFlag(activity: Activity, id: Int): Int =
  if (activity.findViewById<CheckBox>(id).isChecked) {
    map[id] ?: 0
  } else 0

private fun Activity.getDestination(): Class<out Activity> =
  when {
    findViewById<RadioButton>(R.id.dest_a).isChecked -> MainActivity::class.java
    findViewById<RadioButton>(R.id.dest_b).isChecked -> SecondActivity::class.java
    findViewById<RadioButton>(R.id.dest_c).isChecked -> ThirdActivity::class.java
    findViewById<RadioButton>(R.id.dest_d).isChecked -> FourthActivity::class.java
    else                                             -> MainActivity::class.java
  }

private val map: Map<Int, Int> = mapOf(
  R.id.flag_activity_clear_task to Intent.FLAG_ACTIVITY_CLEAR_TASK,
  R.id.flag_activity_clear_top to Intent.FLAG_ACTIVITY_CLEAR_TOP,
  R.id.flag_activity_new_task to Intent.FLAG_ACTIVITY_NEW_TASK,
  R.id.flag_activity_single_top to Intent.FLAG_ACTIVITY_SINGLE_TOP,
  R.id.flag_activity_task_on_home to Intent.FLAG_ACTIVITY_TASK_ON_HOME,
)

private val names: Map<Int, String> = mapOf(
  Intent.FLAG_ACTIVITY_CLEAR_TASK to "Intent.FLAG_ACTIVITY_CLEAR_TASK",
  Intent.FLAG_ACTIVITY_CLEAR_TOP to "Intent.FLAG_ACTIVITY_CLEAR_TOP",
  Intent.FLAG_ACTIVITY_NEW_TASK to "Intent.FLAG_ACTIVITY_NEW_TASK",
  Intent.FLAG_ACTIVITY_SINGLE_TOP to "Intent.FLAG_ACTIVITY_SINGLE_TOP",
  Intent.FLAG_ACTIVITY_TASK_ON_HOME to "Intent.FLAG_ACTIVITY_TASK_ON_HOME",
)

const val SPECIAL_EXTRA = "SPECIAL_EXTRA"
