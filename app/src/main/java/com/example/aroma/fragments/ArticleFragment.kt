package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aroma.R
import com.example.aroma.adapters.ArticlesAdapter
import com.example.aroma.models.Article
import com.example.aroma.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_categories.pb
import kotlinx.android.synthetic.main.toolbar.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticleFragment : Fragment() {
    var presenter= MainPresenter()
    val args: ArticleFragmentArgs by navArgs()
    var category:String?=null;

    lateinit var articleAdapter:ArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category=args?.category
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pb.visibility=View.VISIBLE;
     //   presenter.getCategories()
        toolbar_backIcon.visibility=View.VISIBLE;
        toolbar_title.text=category

        toolbar_backIcon.setOnClickListener {
            (activity)?.onBackPressed()
        }

        presenter.getArticles(category,this)

    }

    fun onArticlesReceived(articles:List<Article>)
    {
      pb.visibility=View.GONE
      Log.d("ARTICLE",""+articles.size)
      this.articleAdapter= ArticlesAdapter(articles,activity as Context,ArticlesAdapter.OnArticleClicked { article ->




      })

        rv_articles.adapter=articleAdapter
        rv_articles.layoutManager=LinearLayoutManager(activity);


    }

    fun onError(msg:String)
    {
        pb.visibility=View.GONE
    }



}