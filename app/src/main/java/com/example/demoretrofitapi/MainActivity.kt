package com.example.demoretrofitapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoretrofitapi.adapter.HeroRecAdapter
import com.example.demoretrofitapi.api.ApiInterface
import com.example.demoretrofitapi.databinding.ActivityMainBinding
import com.example.demoretrofitapi.model.Superhero
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = HeroRecAdapter(this@MainActivity)
        val layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = adapter
        binding.recView.layoutManager = layoutManager


        lifecycleScope.launchWhenCreated {
            val retrofit = ApiInterface.create()
            val result = retrofit.getAllHeros()

            if (result.isEmpty()) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            } else {
                adapter.submitList(result)
            }
        }
    }
}
