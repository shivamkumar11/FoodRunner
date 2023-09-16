package com.shivam.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgetActivity : AppCompatActivity() {
    lateinit var mNumber: EditText
    lateinit var etEmail: EditText
    lateinit var loginBtn: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)


        mNumber = findViewById(R.id.etMobileNo)
        etEmail = findViewById(R.id.etEmail)
        loginBtn = findViewById(R.id.btnLogin)


        loginBtn.setOnClickListener(View.OnClickListener {
            sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE)
            val savedmobileNo = sharedPreferences.getString("no", "NULL")
            val savedEmail = sharedPreferences.getString("mail", "NULL")
            val savedPass = sharedPreferences.getString("pass", "NULL")

            val userEnterNumber = mNumber.text.toString()
            val userEnterEmail = etEmail.text.toString()
            if (userEnterNumber == savedmobileNo && userEnterEmail == savedEmail) {
                Toast.makeText(this, "Your password is: $savedPass", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@ForgetActivity, MainActivity::class.java))
            } else {
                Toast.makeText(this, "User are not registered..", Toast.LENGTH_LONG).show()

            }

        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}