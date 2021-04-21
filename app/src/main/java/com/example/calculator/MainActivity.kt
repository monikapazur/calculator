package com.example.calculator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var newResult = false
    var noClear = true
    var oldNumber = ""
    var op = "+"
    val history = StringBuilder()
    var click = false
    var result = 0.0
    var new_number: String = ""
    var number = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.historyView).movementMethod = ScrollingMovementMethod()

    }

    fun numberEvent(view: View) {
        if (isNewOp) findViewById<EditText>(R.id.editText).setText("")
        isNewOp = false
        var button_click = findViewById<EditText>(R.id.editText).text.toString()
        var button_select = view as Button
        

        when (button_select.id) {
            findViewById<Button>(R.id.button1).id -> {
                button_click += "1"
                history.append("1")
            }
            findViewById<Button>(R.id.button2).id -> {
                button_click += "2"
                history.append("2")
            }
            findViewById<Button>(R.id.button3).id -> {
                button_click += "3"
                history.append("3")
            }
            findViewById<Button>(R.id.button4).id -> {
                button_click += "4"
                history.append("4")
            }
            findViewById<Button>(R.id.button5).id -> {
                button_click += "5"
                history.append("5")
            }
            findViewById<Button>(R.id.button6).id -> {
                button_click += "6"
                history.append("6")
            }
            findViewById<Button>(R.id.button7).id -> {
                button_click += "7"
                history.append("7")
            }
            findViewById<Button>(R.id.button8).id -> {
                button_click += "8"
                history.append("8")
            }
            findViewById<Button>(R.id.button9).id -> {
                button_click += "9"
                history.append("9")
            }
            findViewById<Button>(R.id.button0).id -> {
                button_click += "0"
                history.append("0")
            }
            findViewById<Button>(R.id.ButtonDot).id -> {
                button_click += "."
                history.append(".")
            }
            findViewById<Button>(R.id.ButtonPlusOrMinus).id -> {
                button_click = "-$button_click"
                history.append(button_click)
            }
        }
        findViewById<EditText>(R.id.editText).setText(button_click)
        findViewById<TextView>(R.id.historyView).setText(history)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = findViewById<EditText>(R.id.editText).text.toString()
        //history.append(findViewById<EditText>(R.id.editText).text.toString())
        var button_click = findViewById<EditText>(R.id.editText).text.toString()
        var button_select = view as Button
        when (button_select.id) {
            findViewById<Button>(R.id.ButtonAdd).id -> {
                op = "+"
            }
            findViewById<Button>(R.id.ButtonSubtract).id -> {
                op = "-"
            }
            findViewById<Button>(R.id.ButtonMultiply).id -> {
                op = "*"
            }
            findViewById<Button>(R.id.ButtonDivide).id -> {
                op = "/"
            }
            findViewById<Button>(R.id.ButtonPercent).id -> {
                op = "%"
            }
        }

        history.append(op)
        findViewById<EditText>(R.id.editText).setText(button_click)
        findViewById<TextView>(R.id.historyView).setText(history)
    }

    fun ResultEvent(view: View) {

        if (newResult && noClear) {
            oldNumber = result.toString()
            result.toDouble()
        }
        var newNumber = findViewById<EditText>(R.id.editText).text.toString()

        var button_click = findViewById<EditText>(R.id.editText).text.toString()

        when (op) {
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
                newResult = true
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
                newResult = true
            }
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
                newResult = true
            }
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
                newResult = true
            }

        }

        history.append(" = $result")
        findViewById<TextView>(R.id.resultTextView).setText(result.toString())
        findViewById<EditText>(R.id.editText).setText(button_click)
        findViewById<TextView>(R.id.historyView).setText(history)
    }

    fun CEvent(view: View) {
        findViewById<EditText>(R.id.editText).setText("")
        isNewOp = true
        noClear = false
        result = 0.0
        findViewById<TextView>(R.id.resultTextView).setText("")
        findViewById<TextView>(R.id.historyView).setText("")
        history.clear()
    }

    fun percentEvent(view: View) {
        var no = findViewById<EditText>(R.id.editText).text.toString().toDouble() / 100
        click = true
        findViewById<TextView>(R.id.resultTextView).setText(no.toString())
        findViewById<TextView>(R.id.historyView).setText(no.toString())
        isNewOp = true
    }

    fun backspaceEvent(view: View) {
        number = findViewById<EditText>(R.id.editText).text.toString()
        new_number = ""
        if (number.isNotEmpty()) {
            new_number = number.substring(0, number.length - 1)
        }
        findViewById<EditText>(R.id.editText).setText(new_number)
        findViewById<TextView>(R.id.historyView).setText(new_number)
    }

}
