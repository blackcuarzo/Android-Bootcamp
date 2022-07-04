package com.danielcano.imdbapp.uilayer.uielements.access

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.danielcano.imdbapp.databinding.FragmentRegistrationBinding
import com.danielcano.imdbapp.uilayer.AccessNavigator
import com.danielcano.imdbapp.uilayer.viewmodels.UserRegistrationViewModel

class RegistrationFragment : Fragment() {
    private lateinit var navigator: AccessNavigator
    private val viewModel by viewModels<UserRegistrationViewModel>()
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as AccessNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root

        //Toolbar set up
        val navController = findNavController()
        val toolbar = binding.toolbar
        toolbar.setupWithNavController(navController)

        viewModel.registrationStatus.observe(viewLifecycleOwner) { registrationStatusIsTrue ->
            if (registrationStatusIsTrue) {
                navigator.navigateToMenu()
            }
        }

        val registrationLink = binding.confirmationButton
        registrationLink.setOnClickListener {
            viewModel.registerUser(
                    name = binding.userName.text.toString(),
                    email = binding.userMail.text.toString(),
                    pass = binding.userPass.text.toString()
                )
        }
        return view
    }
}