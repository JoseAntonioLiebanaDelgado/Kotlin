package com.lasalle.newsletter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

private const val ARG_PARAM1 = "param1"

class FragmentExam : Fragment() {
    private var newsletter: Newsletter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            newsletter = it.getSerializable(ARG_PARAM1) as Newsletter?
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvFrase: TextView = view.findViewById(R.id.tv_frase)
        var frase = ""

        if (newsletter?.subscribe == true){
            frase = String.format(getString(R.string.frase_larga), newsletter?.name.toString(), newsletter?.name.toString())
        }else{
            frase = String.format(getString(R.string.frase_corta), newsletter?.name.toString())
        }

        tvFrase.text = frase
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exam, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(jangueo: Newsletter) =
            FragmentExam().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, jangueo)
                }
            }
    }
}