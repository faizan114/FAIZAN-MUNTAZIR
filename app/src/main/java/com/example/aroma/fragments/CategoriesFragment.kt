package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.aroma.R
import com.example.aroma.adapters.CategoriesAdapter
import com.example.aroma.models.Category
import com.example.aroma.models.User
import com.example.aroma.presenter.IMainView
import com.example.aroma.presenter.MainPresenter
import com.example.aroma.utility.SharedPrefrences
import com.example.aroma.view.MainActivity
import com.example.aroma.view.MainViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


class CategoriesFragment() : BaseFragment(),IMainView, NavigationView.OnNavigationItemSelectedListener  {
        var presenter=MainPresenter(this)
       lateinit var categoriesAdapter:CategoriesAdapter
        lateinit var mainView :MainActivity
        lateinit var  vm:MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         mainView=activity as MainActivity;

         pb.visibility=View.VISIBLE;
         presenter.getCategories()

        toolbar_backIcon.setImageDrawable(activity?.getDrawable(R.drawable.icon_menu))
        tollbar.toolbar_backIcon.setOnClickListener {
            (activity as MainActivity).openDrawer()
        }
        initViews()
        observeViewModel()
        setUpToolBar()

        setListeners()
     //  message("TEST MESSAGE")
    }

    fun setListeners()
    {

        et_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                categoriesAdapter.filter.filter(s.toString())
            }
        })
    }


    fun observeViewModel()
    {
//        mainViewModel?.refreshLiveDataEvent?.observe(viewLifecycleOwner, { item->
//            Log.d("refresH","refresh")
//            initViews()
//
//        })
    }
  fun  initViews()
    {

        toolbar_title.text=getString(R.string.mint_varities)
        vm= ViewModelProvider(this).get(MainViewModel::class.java)
        vm.refreshLiveDataEvent.observe(viewLifecycleOwner) {
            it
            if (it) {
                var nav = navHostFragment.findNavController();
                val timer = Timer()
                timer.schedule(timerTask {
                    activity?.runOnUiThread(Runnable {
                        nav.navigate(R.id.farmerRegistration);
                    })
                }, 100)
            }
        }


    }

    fun setUpToolBar()
    {
        searchIcon.setOnClickListener {
            tools_layout.visibility=View.GONE;
            searchLayout.visibility=View.VISIBLE;
        }
        searchCloseIcon.setOnClickListener {
            tools_layout.visibility=View.VISIBLE;
            searchLayout.visibility=View.GONE;
        }
    }

    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun onUserCreated() {
        TODO("Not yet implemented")
    }

    override fun onError(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onSuccess() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(msg: String) {
        TODO("Not yet implemented")
    }

    override fun onLoginSuccesful() {
        TODO("Not yet implemented")
    }

    override fun onCategoriesRetrieved(list: ArrayList<Category>) {

        Log.d("Recieved","Categegores  " + list.size)
      //  mainView.showSnack("GETT")
        pb.visibility=View.GONE
        categoriesAdapter= CategoriesAdapter(list,activity as Context, CategoriesAdapter.OnCategoryClicked({a,b->
            var bundle=Bundle();
            bundle.putString("category",a);
            bundle.putString("categoryNameHindi",b);
            findNavController().navigate(R.id.articleFragment,bundle)

        }),SharedPrefrences.getUserLanguage(activity as Context).equals("hi",true));


        rv_cats.adapter=categoriesAdapter
        categoriesAdapter.notifyDataSetChanged();
        rv_cats.layoutManager=GridLayoutManager(activity,3)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {



        return  true;
    }


}