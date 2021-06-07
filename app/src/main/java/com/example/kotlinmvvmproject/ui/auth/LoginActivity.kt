package com.example.kotlinmvvmproject.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvmproject.R
import com.example.kotlinmvvmproject.databinding.ActivityLoginBinding
import com.example.kotlinmvvmproject.util.toast

class LoginActivity : AppCompatActivity(),AuthListener {
    // to connect AuthViewModel to activity we need interface
    // to bind the viewModel we need to remove setContentView(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_login)
        // ActivityLoginBinding class is automatic generated
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this


    }

    override fun onStarted() {
        // these toast are coming from extension function from viewUtil.kt class
        toast("Login started")
    }

    override fun onSuccess() {
        toast("Login success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}