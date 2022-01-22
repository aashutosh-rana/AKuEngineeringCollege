package com.bcebhagalpur.akuengineeringcollege

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bcebhagalpur.akuengineeringcollege.databasehelper.Insert

class MainActivity2 : AppCompatActivity() {

    lateinit var name:EditText
    lateinit var lastName:EditText
    lateinit var number:EditText
    lateinit var email:EditText
    lateinit var btnCreateAccount:Button
    lateinit var dataBaseInsert: Insert

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        name=findViewById(R.id.etName)
        lastName=findViewById(R.id.etLastName)
        number=findViewById(R.id.etNumber)
        email=findViewById(R.id.etEmail)
        btnCreateAccount=findViewById(R.id.btnCreateAccount)
        dataBaseInsert= Insert(this)
        btnCreateAccount.setOnClickListener { insertFunction() }
    }
    fun insertFunction(){
        val strName=name.text.toString()
        val strLastName=lastName.text.toString()
        val strNumber=number.text.toString()
        val strEmail=email.text.toString()

        val result:Boolean=dataBaseInsert.insertData(strName,strLastName,strNumber,strEmail)

        when{
            result->Toast.makeText(this,"data inserted",Toast.LENGTH_SHORT).show()
            else->Toast.makeText(this," fail to data inserted",Toast.LENGTH_SHORT).show()
        }
    }

}
