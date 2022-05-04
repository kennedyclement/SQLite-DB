package com.ck.room

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class UserDBHelper(context: Context) : SQLiteOpenHelper(context, "Students", null, 1) {


    val tableName = "Student"
    val name = "Name"
    val address   = "Address"
    val mark    = "Mark"
    override fun onCreate(database: SQLiteDatabase?) {

        database?.execSQL("create table $tableName(UserID integer primary key autoincrement,$name Text, $address Text ,$mark Text)")

        database?.execSQL("insert into $tableName($name,$address,$mark) VALUES ('clement', 'T.malai','92')")
        database?.execSQL("insert into $tableName($name,$address,$mark) VALUES ('john', 'chennai','98')")

    }

    override fun onUpgrade(database: SQLiteDatabase?, p1: Int, p2: Int) {

        database!!.execSQL("drop table if exists $tableName")
        onCreate(database)
    }
fun insertData(pname:String,paddress:String,pmark:String):Boolean{

    Log.d("some message","insertData method")
    var db = this.writableDatabase

    var contentValue = ContentValues()

    contentValue.put(name,pname)
    contentValue.put(address,paddress)
    contentValue.put(mark,pmark)

   val result =  db.insert(tableName,null,contentValue)

    db.close()
    return result != -1L
}
    fun getName(): Cursor? {


        val db = this.readableDatabase


       val cursor =  db.rawQuery("SELECT * FROM " + tableName, null)


        return cursor

    }


}