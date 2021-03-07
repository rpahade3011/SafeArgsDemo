package com.bundle.safeargsdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bundle.safeargsdemo.databinding.FragmentDetailsBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Details.newInstance] factory method to
 * create an instance of this fragment.
 */
class Details : Fragment() {

    private var _detailsBinding: FragmentDetailsBinding? = null
    private val binding get() = _detailsBinding!!

    // get the arguments from the Registration fragment
    private val args: DetailsArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _detailsBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = _detailsBinding!!.root

        // Receive the arguments in a variable
        val userDetails = args.user

        // set the values to respective textViews
        binding.tvName.text = userDetails.name
        binding.tvEmail.text = userDetails.email
        binding.tvPassword.text = userDetails.password

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _detailsBinding = null
    }
}