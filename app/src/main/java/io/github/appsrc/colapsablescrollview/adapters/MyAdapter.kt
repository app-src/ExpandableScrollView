package io.github.appsrc.colapsablescrollview.adapters

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import io.github.appsrc.colapsablescrollview.MainActivity
import io.github.appsrc.colapsablescrollview.R
import io.github.appsrc.colapsablescrollview.fragments.ExpandedFragment

class MyAdapter(
    private val  listener : ExpandCollapse
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var screenHeight = 0
    private var screenWidth = 0
    private val displayMetrics = DisplayMetrics()
    private var isExpanded: Int = 0

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.collapsed_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        (parent.context as MainActivity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        screenWidth = displayMetrics.widthPixels
        screenHeight = displayMetrics.heightPixels
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_colapsed, parent, false)
        view.setOnClickListener(View.OnClickListener {
            if (isExpanded == 0) {
                isExpanded = 1
                listener.fullScreen(view)
            } else {
                isExpanded = 0
                listener.collapse(view)
            }

        })
        return ViewHolder(view)
    }

    interface ExpandCollapse {
        fun fullScreen(view: View?)
        fun collapse(view: View?)
    }


    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //not required

    }

}
