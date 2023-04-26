package io.github.appsrc.colapsablescrollview.adapters

import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.appsrc.colapsablescrollview.MainActivity
import io.github.appsrc.colapsablescrollview.R

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.collapsed_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_colapsable, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //not required

    }

}
