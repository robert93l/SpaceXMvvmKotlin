package com.example.spacexmvvmkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexmvvmkotlin.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ViewModelLaunch by viewModels()
    private lateinit var launchAdapter: AdapterSpacex

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        setUpViewModel()


    }

    private fun setUpRecyclerView() {
        launchAdapter = AdapterSpacex()
        binding.recyclerSpace.layoutManager = LinearLayoutManager(this)
        binding.recyclerSpace.adapter = launchAdapter
    }

    private fun setUpViewModel() {

        val repository = LaunchRepository(spaceXRetrofit)

        viewModel.fetchLaunches()
        viewModel.launches.observe(this, Observer { launches ->
            launchAdapter.setLaunches(launches)
            launchAdapter.notifyDataSetChanged()
        })
    }
}


