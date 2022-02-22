package net.chris.experiment.investigatetask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setTexts()
    findViewById<Button>(R.id.forward).setOnClickListener { startActivity(handle()) }
    findViewById<RadioButton>(R.id.dest_c).isChecked = true
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    findViewById<TextView>(R.id.task_info).text = "task $taskId"
  }

  private fun setTexts() {
    findViewById<TextView>(R.id.name).text = "B"
    findViewById<TextView>(R.id.info).text = intent.getStringExtra(SPECIAL_EXTRA) ?: ""
    findViewById<TextView>(R.id.task_info).text = "task $taskId"
  }
}
