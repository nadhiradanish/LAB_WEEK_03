package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // tambahkan 5 view kopi (pastikan id-nya ada di fragment_list.xml)
        val coffeeList = listOf<View>(
            view.findViewById(R.id.affogato),
            view.findViewById(R.id.americano),
            view.findViewById(R.id.latte),
            view.findViewById(R.id.espresso),      // item baru
            view.findViewById(R.id.cappuccino)     // item baru
        )

        coffeeList.forEach { coffee ->
            coffee.setOnClickListener {
                val fragmentBundle = Bundle().apply {
                    putInt(COFFEE_ID, coffee.id)
                }

                findNavController().navigate(
                    R.id.coffee_id_action,
                    fragmentBundle
                )
            }
        }
    }

    companion object {
        const val COFFEE_ID = "COFFEE_ID"
    }
}
