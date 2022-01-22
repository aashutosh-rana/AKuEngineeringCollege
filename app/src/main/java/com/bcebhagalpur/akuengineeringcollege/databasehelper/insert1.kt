package com.bcebhagalpur.akuengineeringcollege.databasehelper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert.Insert.PersonTable.Companion.LAST_NAME_COLUMN
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert.Insert.PersonTable.Companion.NAME_COLUMN
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert.Insert.PersonTable.Companion.TABLE_NAME
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert.Insert.PersonTable.Companion.USER_EMAIL
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert.Insert.PersonTable.Companion.USER_NUMBER


class Insert(context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val personTable=  TABLE_NAME+ +"("+BaseColumns._ID + NAME_COLUMN + LAST_NAME_COLUMN + USER_NUMBER+ USER_EMAIL+")"
        db!!.execSQL(personTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }
    fun insertData(name:String, last_name:String, number:String, email:String):Boolean{
        val db:SQLiteDatabase=this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(NAME_COLUMN,name)
        contentValues.put(LAST_NAME_COLUMN,last_name)
        contentValues.put(USER_NUMBER,number)
        contentValues.put(USER_EMAIL,email)
        val insertData= db.insert(TABLE_NAME,null,contentValues)
        db.close()
        return !insertData.equals(-1)
    }
    companion object{
        private const val DATABASE_NAME="Person.db"
        private const val DATABASE_VERSION=1
    }
    object Insert{
        class PersonTable:BaseColumns{
            companion object{
                const val TABLE_NAME="Person_table"
                const val NAME_COLUMN="NAME"
                const val LAST_NAME_COLUMN="LASTNAME"
                const val USER_NUMBER="NUMBER"
                const val USER_EMAIL="EMAIL"

            }
        }
    }
}