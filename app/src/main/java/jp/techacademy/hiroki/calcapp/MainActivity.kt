package jp.techacademy.hiroki.calcapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addbutton.setOnClickListener(this)
        subbutton.setOnClickListener(this)
        multibutton.setOnClickListener(this)
        divbutton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this,SecondActivity::class.java)
        val edittext1 = findViewById<EditText>(R.id.editText1)
        val edittext2 = findViewById<EditText>(R.id.editText2)

        if(edittext1.text.toString() == "" || edittext2.text.toString() == "") {
            warningtext.text = "数値入力漏れがあります"
            warningtext.setBackgroundColor(Color.RED)
        }else {
            intent.putExtra("VALUE1", edittext1.text.toString())
            intent.putExtra("VALUE2", edittext2.text.toString())
            intent.putExtra("OPERATORID", v.id)
            startActivity(intent)
        }
    }

}
