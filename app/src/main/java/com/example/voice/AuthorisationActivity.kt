package com.example.voice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.ui.VKConfirmationActivity.Companion.result
import com.vk.api.sdk.utils.VKUtils
import java.lang.Exception

class AuthorisationActivity : AppCompatActivity() {

    val authLauncher = VK.login(this) { result : VKAuthenticationResult ->
        when (result) {
            is VKAuthenticationResult.Success -> onLogin()
            is VKAuthenticationResult.Failed -> onLoginFailed(result.exception)
        }
    }

    fun onLogin(){
        Toast.makeText(this, "Успешно",Toast.LENGTH_SHORT).show()
    }

    fun onLoginFailed(exception: Exception){
        Toast.makeText(this, "Ошибка",Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorisation)
        val fingerprints: Array<String?>? = VKUtils.getCertificateFingerprint(this, this.packageName)

        val loginBtn = findViewById<Button>(R.id.btnVKlogin)
        loginBtn.setOnClickListener {
            authLauncher.launch(arrayListOf(VKScope.WALL, VKScope.PHOTOS))
        }
    }

    companion object {
        fun start(context: Context){
            context.startActivity(Intent(context, AuthorisationActivity::class.java))
        }
    }
}