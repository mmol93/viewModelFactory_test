package com.example.viewmodelfactory_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelfactory_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mainViewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // dataBinding 이랑 liveData를 결합
        mainViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {
            val data =binding.editText.text.toString().toInt()
            mainViewModel.number.value = (mainViewModel.number.value)!!.plus(data)
        }
    }
}