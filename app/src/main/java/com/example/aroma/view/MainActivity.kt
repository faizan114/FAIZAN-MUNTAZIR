package com.example.aroma.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.GravityCompat
import com.example.aroma.R
import com.example.aroma.User
import com.example.aroma.models.Category
import com.example.aroma.presenter.IMainView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottomsheet_language_changer.*
import kotlinx.android.synthetic.main.fragment_bottomsheet_language_changer.view.*


import com.google.android.material.navigation.NavigationView


import androidx.drawerlayout.widget.DrawerLayout
import com.example.aroma.utility.SharedPrefrences
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask
import android.os.Build

import android.annotation.TargetApi
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.aroma.fragments.FarmerRegistration


class MainActivity : AppCompatActivity(),IMainView,NavigationView.OnNavigationItemSelectedListener {

    lateinit var progressBar:ProgressBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.aroma.R.layout.activity_main)
//        progressBar=findViewById(com.example.aroma.R.id.pb)
        navView.setNavigationItemSelectedListener(this);

    }



    override fun createUser(user: User) {

    }

    override fun onUserCreated() {

    }

    override fun onError(msg: String) {
       showSnack(msg)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {

    }

    override fun onSuccess(msg: String) {
        showSnack(msg)
    }

    override fun onLoginSuccesful() {
        TODO("Not yet implemented")
    }

    override fun onCategoriesRetrieved(list: ArrayList<Category>) {
        TODO("Not yet implemented")
    }


    fun openLanguageChangeSheet()
    {

        val dialog = BottomSheetDialog(this)
        // on below line we are inflating a layout file which we have created.
        val view = layoutInflater.inflate(R.layout.fragment_bottomsheet_language_changer, null)
        // on below line we are adding on click listener
        // for our dismissing the dialog button.
   view.close_bottom_sheet.setOnClickListener {
            // on below line we are calling a dismiss
            // method to close our dialog.
            dialog.dismiss()
        }

      view.english.setOnClickListener{
          SharedPrefrences.storeUserLanguage("EN",this as Context)
          updateResourcesLocale(this,Locale("EN"))
           refreshCurrentFragment()
          dialog.dismiss()
        }

        view.hindi.setOnClickListener {
            SharedPrefrences.storeUserLanguage("HI",this as Context)
            updateResourcesLocale(this, Locale("hi"))
           refreshCurrentFragment()
            dialog.dismiss();
        }
        // below line is use to set cancelable to avoid
        // closing of dialog box when clicking on the screen.
        dialog.setCancelable(false)

        // on below line we are setting
        // content view to our view.
        dialog.setContentView(view)

        // on below line we are calling
        // a show method to display a dialog.
        dialog.show()
    }

    fun showSnack(msg:String)
    {
        val snackbar = Snackbar.make(
            coordinator_layout,
            msg,
            Snackbar.LENGTH_LONG
        )
        snackbar.show()
    }

    public  fun showProgressBar()
    {
//     progressBar.visibility= View.VISIBLE
    }

    fun hideProgressBar()
    {
      // progressBar.visibility=View.GONE
    }


 public  fun   openDrawer()
    {
      my_drawer_layout.openDrawer(GravityCompat.START)
 }

 public   fun  closeDrawer()
    {
        my_drawer_layout.closeDrawer(GravityCompat.START)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        closeDrawer()
        val id = item.itemId
        if(item.itemId==R.id.nav_change_language)
        {
            val timer = Timer()
            timer.schedule(timerTask { runOnUiThread(Runnable {
                openLanguageChangeSheet()
            })}, 300)
        }


        if(item.itemId==R.id.nav_registra)
        {
            //  Navigation.findNavController(this,R.id.navHostFragment)
             var nav=navHostFragment.findNavController();
            val timer = Timer()
            timer.schedule(timerTask { runOnUiThread(Runnable {
               nav.navigate(R.id.farmerRegistration);
            })}, 100)
        }

        return true
    }

    fun openReg()
    {
       // this.findNavController().navigate()

    }

//LANGAUE CHANGE

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(updateBaseContextLocale(base))
    }

    private fun updateBaseContextLocale(context: Context): Context? {
        val language: String = SharedPrefrences.getUserLanguage(context)
        val locale = Locale(language)
        Locale.setDefault(locale)
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateResourcesLocale(context, locale)
        } else updateResourcesLocaleLegacy(context, locale)
    }
    @TargetApi(Build.VERSION_CODES.N)
    private fun updateResourcesLocale(context: Context, locale: Locale): Context? {
        val configuration: Configuration = context.resources.configuration
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLocaleLegacy(context: Context, locale: Locale): Context? {
        val resources: Resources = context.resources
        val configuration: Configuration = resources.getConfiguration()
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.getDisplayMetrics())
        return context
    }

    private fun refreshCurrentFragment(){
        this.finish()
        startActivity(Intent(this,SplashScreen::class.java))
    }



}