package com.example.post.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.post.databinding.ActivityPostsBinding


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}