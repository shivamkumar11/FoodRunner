package com.shivam.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    lateinit var confirmPasswordDetail: String

    lateinit var sharedPreferences: SharedPreferences
    lateinit var registerBtn: Button
    lateinit var userName: EditText
    lateinit var userEmail: EditText
    lateinit var userMobNo: EditText
    lateinit var userDelivery: EditText
    lateinit var userPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE)

        registerBtn = findViewById(R.id.btnRegister)
        userName = findViewById(R.id.etUserName)
        userEmail = findViewById(R.id.etUserEmail)
        userMobNo = findViewById(R.id.etUserNo)
        userDelivery = findViewById(R.id.etUserDeliveryAddress)
        userPassword = findViewById(R.id.etUserPassword)

        registerBtn.setOnClickListener(View.OnClickListener {



            sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE)
            sharedPreferences.edit().putString("nam", userName.text.toString())
                .apply()
            sharedPreferences.edit().putString("mail", userEmail.text.toString())
                .apply()
            sharedPreferences.edit().putString("no", userMobNo.text.toString())
                .apply()
            sharedPreferences.edit().putString("location", userDelivery.text.toString())
                .apply()
            sharedPreferences.edit().putString("pass", userPassword.text.toString())
                .apply()

             startActivity(Intent(this@SignupActivity, LoginActivity::class.java))

            //   a.putExtra("confirmPassword", userConfirmPasswords.text.toString())
            Toast.makeText(
                this,
                "Registration Successfully\n Now you can LogIn",
                Toast.LENGTH_SHORT
            ).show()


        })

        title = "Register Yourself"
    }
}