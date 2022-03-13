package com.example.aroma.fragments

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
import kotlinx.android.synthetic.main.fragment_register.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Register.newInstance] factory method to
 * create an instance of this fragment.
 */
class Register : BaseFragment() ,IMainView{

     lateinit var presenter:MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         presenter= MainPresenter(this,activity)
        signup.setOnClickListener { if(validate())
        {
            var user=User()
            user.name=name.text.toString();
            user.phone=phonenumber.text.toString()
            user.email=email.text.toString()
            user.password=password.text.toString()
            showProgressDialog("Please wait","Creating your account",false)
            presenter.createUser(user,user.password)
        }}
    }


    fun  validate():Boolean
    {
        if(name.text.toString().isEmpty())
        {
            message("Please enter name")
            return false;
        }


        if(phonenumber.text.toString().isEmpty())
        {
            message("Please enter phone number")
            return false;
        }


        if(email.text.toString().isEmpty())
        {
            message("Please enter email")
            return false;
        }

        if(password.text.toString().isEmpty())
        {
            message("Please enter password")
            return false;
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
      message(msg)
        dismissDialog()
    }

    override fun onError() {

        dismissDialog()
    }

    override fun onSuccess() {


        dismissDialog()
    }

    override fun onSuccess(msg: String) {

        message(msg)
        dismissDialog()
    }

    override fun onLoginSuccesful() {
        findNavController().navigate(R.id.categoriesFragment)
    }

    override fun onCategoriesRetrieved(list: ArrayList<Category>) {

    }

}