package io.github.appsrc.colapsablescrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.appsrc.colapsablescrollview.adapters.MyAdapter
import io.github.appsrc.colapsablescrollview.databinding.ActivityMainBinding
import io.github.appsrc.colapsablescrollview.helpers.CenterZoomLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = MyAdapter()
        binding.recyclerView.layoutManager = CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL , false)
    }

}