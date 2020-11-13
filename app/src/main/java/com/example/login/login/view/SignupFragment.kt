package com.example.login.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.login.R
import com.google.android.material.textfield.TextInputLayout


class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val name = view.findViewById<TextInputLayout>(R.id.edt_name_signup).editText
        val email = view.findViewById<TextInputLayout>(R.id.edt_email_signup).editText
        val password = view.findViewById<TextInputLayout>(R.id.edt_password_signup).editText
        val repeatPassword = view.findViewById<TextInputLayout>(R.id.edt_repeatPassword_signup).editText

        view.findViewById<ImageView>(R.id.img_back_signup).setOnClickListener {
            navController.popBackStack()
        }

        view.findViewById<Button>(R.id.btn_register_signup).setOnClickListener {
            when {
                name?.text.isNullOrEmpty() -> name?.error = getString(R.string.digite_o_nome)
            }
            when {
                email?.text.isNullOrEmpty() -> email?.error = getString(R.string.digite_o_email)
            }
            when {
                password?.text.isNullOrEmpty() -> password?.error = getString(R.string.digite_a_senha)
            }
            when {
                repeatPassword?.text.isNullOrEmpty() -> repeatPassword?.error = getString(R.string.digite_a_senha)
            }
            if (!(name?.text.isNullOrEmpty())
                && !(email?.text.isNullOrEmpty())
                && !(password?.text.isNullOrEmpty())
                && !(repeatPassword?.text.isNullOrEmpty())){


                when {
                    password?.text.toString().trim().length > MAX_CHARACTER_PASSWORD
                            || password?.text.toString().trim().length < MIN_CHARACTER_PASSWORD -> {
                        password?.error = getString(R.string.deve_conter)
                    }
                    password?.text.toString().trim() != repeatPassword?.text.toString().trim() -> {
                        repeatPassword?.error = getString(
                            R.string.as_senhas_devem_ser_iguais)
                    }
                    else ->  navController.navigate(R.id.action_signupFragment2_to_restaurantListFragment)

                }
            }


        }
    }

    companion object {
        const val MIN_CHARACTER_PASSWORD = 4
        const val MAX_CHARACTER_PASSWORD = 12
    }

}