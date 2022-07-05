package com.danielcano.imdbapp.uilayer.uielements.access

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.danielcano.imdbapp.uilayer.AccessNavigator
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.databinding.FragmentLoginBinding
import com.danielcano.imdbapp.uilayer.viewmodels.UserLoginViewModel
import com.danielcano.imdbapp.uilayer.viewmodels.UserRegistrationViewModel
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var navigator: AccessNavigator
    private val viewModel by viewModels<UserLoginViewModel>()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigator = context as AccessNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()

        viewModel.loginStatus.observe(viewLifecycleOwner) { loginStatusIsTrue ->
            if (loginStatusIsTrue) {
                val action = LoginFragmentDirections.actionLoginFragmentToMenuActivity(
                    userName = viewModel.loginData.value!!
                )
                navController.navigate(action)
            }
        }

        val guestRegistrationDirection = LoginFragmentDirections.actionLoginFragmentToMenuActivity(
            userName = getString(R.string.default_username)
        )
        binding.guestLink.setOnClickListener {
            navController.navigate(guestRegistrationDirection)
        }

        val registrationDirection =
            LoginFragmentDirections.actionLoginFragmentToRegistrationFragment()
        binding.registrationLink.setOnClickListener {
            navController.navigate(registrationDirection)
        }

        binding.loginButton.setOnClickListener {
            viewModel.loginUser(
                binding.userName.text.toString(),
                binding.userPass.text.toString()
            )
        }
        return view
    }

}