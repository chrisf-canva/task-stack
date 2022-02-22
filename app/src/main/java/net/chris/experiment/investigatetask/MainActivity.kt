package net.chris.experiment.investigatetask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setTexts()
    findViewById<Button>(R.id.forward).setOnClickListener { startActivity(handle()) }
    findViewById<RadioButton>(R.id.dest_b).isChecked = true
  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    findViewById<TextView>(R.id.task_info).text = "task $taskId"
  }

  private fun setTexts() {
    findViewById<TextView>(R.id.name).text = "A"
    findViewById<TextView>(R.id.info).text = "from ${intent.getStringExtra(SPECIAL_EXTRA)}"
    findViewById<TextView>(R.id.task_info).text = "task $taskId"
  }
}
