package io.github.appsrc.colapsablescrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.appsrc.colapsablescrollview.adapters.MyAdapter
import io.github.appsrc.colapsablescrollview.databinding.ActivityMainBinding
import io.github.appsrc.colapsablescrollview.fragments.ExpandedFragment
import io.github.appsrc.colapsablescrollview.helpers.CenterZoomLayoutManager

class MainActivity : AppCompatActivity(), MyAdapter.ExpandCollapse{
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.adapter = MyAdapter(this)
        val layoutManager = CenterZoomLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager

    }
    override fun fullScreen(view: View?) {
        binding.recyclerView.visibility = View.GONE

        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_view,
            ExpandedFragment()
        ).commit()
    }

    override fun collapse(view: View?) {
        binding.recyclerView.visibility = View.VISIBLE
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_container_view,
            ExpandedFragment()
        ).commit()
    }

}