package com.example.aroma.presenter

import com.example.aroma.User
import com.example.aroma.models.Category

interface IMainView {
    fun createUser(user: User)
    fun onUserCreated()
    fun onError(msg:String)
    fun onError()
    fun onSuccess()
    fun onSuccess(msg:String)
    fun onLoginSuccesful()
    fun onCategoriesRetrieved(list:ArrayList<Category>)


}