package com.bundle.safeargsdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bundle.safeargsdemo.databinding.ActivityUserChoiceBinding

class UserChoiceActivity : AppCompatActivity() {

    private var _userChoiceBinding: ActivityUserChoiceBinding? = null
    private val binding get() = _userChoiceBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _userChoiceBinding = ActivityUserChoiceBinding.inflate(layoutInflater)
        val view = _userChoiceBinding!!.root
        setContentView(view)

        // Opening the example as per user selection
        binding.btnContinueToDemo.setOnClickListener {
            val intentToNavigate = Intent(this, DemoActivity::class.java)
            startActivity(intentToNavigate)
        }
    }
}