package com.bundle.safeargsdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bundle.safeargsdemo.databinding.FragmentRegistrationBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Registration.newInstance] factory method to
 * create an instance of this fragment.
 */
class Registration : Fragment() {

    private var _registrationBinding: FragmentRegistrationBinding? = null
    private val binding get() = _registrationBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _registrationBinding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = _registrationBinding!!.root

        // call onClick on the SendButton
        binding.buttonSend.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // create user object and pass the required arguments
            // that is name, email,and password
            val user = User(name, email, password)

            // create an action and pass the the required user object to it
            // If you can not find the RegistrationDirection try to "Build project"
            val action = RegistrationDirections.actionNavigateFromRegistrationToDetails(user)

            // this will navigate the current fragment i.e
            // Registration to the Detail fragment
            findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _registrationBinding = null
    }
}