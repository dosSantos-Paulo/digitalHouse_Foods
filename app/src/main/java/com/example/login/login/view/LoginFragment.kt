package com.example.login.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.login.R
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val email = view.findViewById<TextInputLayout>(R.id.edt_email_login).editText
        val password = view.findViewById<TextInputLayout>(R.id.edt_password_login).editText

        view.findViewById<Button>(R.id.btn_register_login).setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment2)
        }

        view.findViewById<Button>(R.id.btn_login_login).setOnClickListener {
            when {
                email?.text.isNullOrEmpty() -> email?.error = getString(R.string.digite_o_email)
            }
            when {
                password?.text.isNullOrEmpty() -> password?.error = getString(R.string.digite_a_senha)
            }

            if (!(email?.text.isNullOrEmpty()) && !(password?.text.isNullOrEmpty())) {
                navController.navigate(R.id.action_loginFragment_to_restaurantListFragment)
            }
        }
    }

}