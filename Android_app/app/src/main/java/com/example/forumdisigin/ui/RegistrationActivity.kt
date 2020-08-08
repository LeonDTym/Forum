package com.example.forumdisigin.ui
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.forumdisigin.R
import com.example.forumdisigin.ui.login.LoginActivity


class RegistrationActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.forumdisigin.R.layout.activity_registration)

        val firstName = findViewById<EditText>(R.id.first_name)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)

        if( firstName.text.toString().length == null )
            firstName.error = "First name is required!"

    }



    fun goLogin(view: View) {
        val intent = Intent(this@RegistrationActivity, LoginActivity::class.java)
        startActivity(intent)
    }


}
