package com.juhnowski.ilya.book

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var userInput: EditText ?= null
    private var button: Button?= null
    private var button2: Button?= null
    private var textView: TextView?= null
    private var numTimesClicked = 0;

    private val TAG = "MainActivity"
    private val TEXT_CONTENTS = "TextContent"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userInput = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        button2 = findViewById<Button>(R.id.button2)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        button?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                numTimesClicked += 1;
                textView?.append("\n Привет, ${userInput?.text} ! \n Кнопка нажата $numTimesClicked раз")
                userInput?.setText("")
            }

        })

        button2?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                textView?.setText("")
            }

        })

    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        Log.d(TAG,"onSaveInstanceState called")
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS,"")
    }
}
