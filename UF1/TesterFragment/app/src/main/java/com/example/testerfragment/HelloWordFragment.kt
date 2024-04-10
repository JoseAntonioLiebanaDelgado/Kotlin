package com.example.testerfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HelloWorldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_hello_word, container, false)

        view.findViewById<Button>(R.id.buttonBack).setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }
}