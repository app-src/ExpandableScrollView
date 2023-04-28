package io.github.appsrc.colapsablescrollview.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.github.appsrc.colapsablescrollview.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExpandedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExpandedFragment : Fragment() {
    private var param1: Context? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(R.layout.fragment_expanded, null)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_expanded, container, false)
        view?.findViewById<ImageView>(R.id.imageView)?.setOnClickListener(View.OnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().findViewById<RecyclerView>(R.id.recycler_view).visibility = View.VISIBLE
        })
        view?.findViewById<Button>(R.id.button)?.setOnClickListener(View.OnClickListener {
            Log.d("Fragment","Getting clicked")
            Toast.makeText(activity,"Clicked Schedule Trip",Toast.LENGTH_SHORT).show()
        })
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExpandedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}