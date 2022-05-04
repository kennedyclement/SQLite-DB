package com.ck.room

import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var list :ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeData()








    }

    fun storeData() {
        var helper = UserDBHelper(applicationContext)

        save_btn.setOnClickListener {
            if (edName.text.isEmpty() || edAddress.text.isEmpty() || edMark.text.isEmpty() ) {
                Toast.makeText(applicationContext, "Please enter all the information", Toast.LENGTH_SHORT).show()

            }
            else{
                var contentValue = ContentValues()

                helper.insertData(
                    edName.text.toString(),
                    edAddress.text.toString(),
                    edMark.text.toString()
                )
                edName.setText("")

                edAddress.setText("")
                edMark.setText("")

                edName.requestFocus()
                Toast.makeText(applicationContext, "successfully saved", Toast.LENGTH_SHORT).show()

                intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)

            }

        }

    }
    fun readData(){


    }
}













