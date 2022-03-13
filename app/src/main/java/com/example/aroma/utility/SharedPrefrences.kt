package com.example.aroma.utility

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.aroma.models.User
import org.intellij.lang.annotations.Language

class SharedPrefrences {

     companion object {
         private val APP_PREF= "appPrefOne"


         fun isUserLoggedIn(con:Context):Boolean
         {
             val sharedPreference: SharedPreferences =con.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)

            val name=sharedPreference.getString("username","null")
             if(name.equals("null"))
             {
                 return  false
             }

             return  true;
         }


         fun getUserLanguage(context: Context):String{
             val sharedPreference: SharedPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
             var language=sharedPreference.getString("language","EN")!!
             return  language;
         }

         fun  isHindi(con: Context):Boolean
         {
           return  getUserLanguage(con).equals("hi");
         }

         fun storeUser(con:Context,user:User)
         {
             val preferences: SharedPreferences = con.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
             var editor = preferences.edit()
             editor.putString("username",user.email)
             editor.commit()

         }


         fun storeUserLanguage(language:String,context: Context)
         {
             val preferences: SharedPreferences = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
             var editor = preferences.edit()
             editor.putString("language",language)
             editor.commit()

         }


     }
}