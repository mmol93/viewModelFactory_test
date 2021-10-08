package com.example.viewmodelfactory_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelfactory_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binder : ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // viewModel 정의
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // viewModel과 liveData를 레이아웃과 연결
        binder.mainViewModel = mainViewModel
        binder.lifecycleOwner = this

        binder.button.setOnClickListener {
            mainViewModel.number.value = mainViewModel.number.value!! + 1
        }
    }
}