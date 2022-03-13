package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.aroma.R
import com.example.aroma.models.Category
import com.example.aroma.models.User
import com.example.aroma.presenter.IMainView
import com.example.aroma.presenter.MainPresenter
import com.example.aroma.utility.SharedPrefrences
import com.example.aroma.view.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.activity_main.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Login.newInstance] factory method to
 * create an instance of this fragment.
 */
class Login : BaseFragment(),IMainView {

     lateinit var  prersenter:MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(SharedPrefrences.isUserLoggedIn(activity as Context))
        {
            findNavController().navigate(R.id.categoriesFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signup.setOnClickListener { findNavController().navigate(R.id.register) }
        forgotpassword.setOnClickListener { findNavController().navigate(R.id.forgotPasswordFragment) }
          prersenter= MainPresenter(this,activity)
        change_language.setOnClickListener {
            (activity as MainActivity).openLanguageChangeSheet()
        }

        login.setOnClickListener {
            if(validate())
            {
                showProgressDialog("Logging In",false)
                prersenter.signIn(email.text.toString(),password.text.toString())
            }



        }
    }


    fun  validate():Boolean
    {
        if(email.text.isEmpty())
        {

            message("Please enter your email")
            return  false;
        }

        if(password.text.isEmpty())
        {

            message("Please enter password")
            return  false;
        }

        return  true;
    }


    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun onUserCreated() {
        TODO("Not yet implemented")
    }


    override fun onError(msg: String) {
        dismissDialog()
         message(msg)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(msg: String) {
         // showSnack(msg)
    }

    override fun onLoginSuccesful() {
        dismissDialog()
        findNavController().navigate(R.id.categoriesFragment)
    }

    override fun onCategoriesRetrieved(list: ArrayList<Category>) {
        TODO("Not yet implemented")
    }


}