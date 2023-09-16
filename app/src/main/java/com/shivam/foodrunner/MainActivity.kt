package com.shivam.foodrunner

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences


    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var mobNo: TextView
    lateinit var delivery: TextView
    lateinit var password: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        name = findViewById(R.id.etUserName)
        email = findViewById(R.id.etUserEmail)
        mobNo = findViewById(R.id.etUserNo)
        delivery = findViewById(R.id.etUserDeliveryAddress)
        password = findViewById(R.id.etUserPassword)

        sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE)


        val f = sharedPreferences.getString("nam", "NULL")
        val g = sharedPreferences.getString("mail", "NULL")
        val h = sharedPreferences.getString("no", "NULL")
        val i = sharedPreferences.getString("location", "NULL")
        val j = sharedPreferences.getString("pass", "NULL")


        name.text = f
        email.text = g
        mobNo.text = h
        delivery.text = i
        password.text = j


        title=f
        // confirmPasswords.text = intent.getStringExtra("confirmPassword").toString()

        /* Toast.makeText(
             this,
             "$f \n$g \n$h \n$i \n$j",
             Toast.LENGTH_LONG
         ).show()*/


    }
}