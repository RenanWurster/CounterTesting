package com.example.countertesting

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.countertesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    private val TAG = "Log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            binding.tvCounter.text = it.count.toString()
            val textColor = if (it.negative) {
                Color.RED
            } else {
                Color.BLACK
            }
            binding.tvCounter.setTextColor(textColor)
        }

        binding.btnAddCounter.setOnClickListener {
            viewModel.add()
        }

        binding.btnSubCounter.setOnClickListener {
            viewModel.sub()
        }
        Log.i(TAG, "onCreate gestartet!")
    }

}