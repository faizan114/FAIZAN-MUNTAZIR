package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.aroma.R
import com.example.aroma.models.Article
import com.example.aroma.utility.SharedPrefrences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_view_article.*
import kotlinx.android.synthetic.main.toolbar.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ViewArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewArticleFragment : Fragment() {
    val args: ViewArticleFragmentArgs by navArgs()
     var articleString:String="";
     val gson=com.google.gson.Gson();
    var article: Article? =null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_article, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleString=args.article;
        if(articleString!=null)
        {
            article=gson.fromJson(articleString,Article::class.java);
        }


        toolbar_title.text=article?.name
        if(article?.hindiDesciption?.toString()?.lowercase()?.contains("appvideo1231",true) == true  || article?.description?.toString()?.lowercase()?.contains("appvideo1231",true) == true  )

        {
           // articleImage.visibility=View.GONE
        }

        Picasso.get().load(article!!.imageUrl).into(articleImage)



        webview.setWebViewClient(WebViewClient())
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webview.getSettings().setDomStorageEnabled(true);
        Log.d("AR: ",":ARTICLE  "+article?.hindiDesciption)

        var isHindi=SharedPrefrences.getUserLanguage(activity as Context).equals("hi",true)
        if(isHindi) {
            article?.hindiDesciption?.let { webview.loadData(it, "text/html", "UTF-8") };
        }else{
            article?.description?.let { webview.loadData(it, "text/html", "UTF-8") };
        }


    }


}