package com.shivam.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    lateinit var loginBtn: Button
    lateinit var forgetTxt: TextView
    lateinit var signupTxt: TextView
    lateinit var mNumber: EditText
    lateinit var etPass: EditText
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        mNumber = findViewById(R.id.etMobileNo)
        etPass = findViewById(R.id.etEmail)
        loginBtn = findViewById(R.id.btnLogin)
        forgetTxt = findViewById(R.id.txtForget)
        signupTxt = findViewById(R.id.txtSignUp)

        sharedPreferences = getSharedPreferences("logIn", MODE_PRIVATE)

        // first time when user logIn then its default value is shared Preference vLue is false in below line
        val check = sharedPreferences.getBoolean("flag", false)
        if (check) { // for true user is logged in
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        } else { // for false either first time or user is Logged out
            // a = Intent(this@MainActivity, MainActivity::class.java)
        }




        loginBtn.setOnClickListener(View.OnClickListener {
            sharedPreferences = getSharedPreferences("User Details", MODE_PRIVATE)
            val savedmobileNo = sharedPreferences.getString("no", "NULL")
            val savedpassword = sharedPreferences.getString("pass", "NULL")

            val userEnterNumber = mNumber.text.toString()
            val userEnterPassword = etPass.text.toString()
            if (userEnterNumber == savedmobileNo && userEnterPassword == savedpassword) {
                saveSharedPreference()
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            } else if (userEnterNumber == savedmobileNo || userEnterPassword == savedpassword) {
                Toast.makeText(this, "Password error", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "User have not registered..", Toast.LENGTH_LONG).show()
            }

        })

        forgetTxt.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginActivity, ForgetActivity::class.java))

        })

        signupTxt.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))

        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        finish()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    fun saveSharedPreference() {
        //  title = userTitle
        sharedPreferences = getSharedPreferences("logIn", MODE_PRIVATE)
        // here ture value is saved in shared preference with key value =flag
        sharedPreferences.edit().putBoolean("flag", true).apply()
        //  sharedPreferences.edit().putString("Title", title as String).apply()

    }
}