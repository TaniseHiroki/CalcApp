package jp.techacademy.hiroki.calcapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getStringExtra("VALUE1").toDouble()
        val value2 = intent.getStringExtra("VALUE2").toDouble()
        val operatorid = intent.getIntExtra("OPERATORID",0)
        val resulttext = findViewById<TextView>(R.id.resulttext)

        try {
            when (operatorid) {
                R.id.addbutton -> resulttext.text = "${value1 + value2}"
                R.id.subbutton -> resulttext.text = "${value1 - value2}"
                R.id.multibutton -> resulttext.text = "${value1 * value2}"
                R.id.divbutton -> resulttext.text = "${value1 / value2}"
            }
        } catch (e: Exception) {
            resulttext.text = "計算エラー"
            resulttext.setBackgroundColor(Color.RED)
            Log.d("kotlintest", e.message)
        }
    }
}
