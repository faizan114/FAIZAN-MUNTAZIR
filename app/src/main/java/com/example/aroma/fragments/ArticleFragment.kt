package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aroma.R
import com.example.aroma.adapters.ArticlesAdapter
import com.example.aroma.models.Article
import com.example.aroma.presenter.MainPresenter
import com.example.aroma.utility.SharedPrefrences
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
    var hindiCatnAMe:String?=null;

    lateinit var articleAdapter:ArticlesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category=args?.category
        hindiCatnAMe=args?.categoryNameHindi

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
        if(SharedPrefrences.getUserLanguage(activity as Context).equals("hi",true))
        {
            toolbar_title.text=hindiCatnAMe
        }else
        toolbar_title.text=category

        setUpToolBar()
        toolbar_backIcon.setOnClickListener {
            (activity)?.onBackPressed()
        }

        presenter.getArticles(category,this)

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

                articleAdapter.filter.filter(s.toString())
            }
        })

    }

    fun onArticlesReceived(articles:List<Article>)
    {
      pb.visibility=View.GONE
      Log.d("ARTICLE",""+articles.size)
      this.articleAdapter= ArticlesAdapter(articles,activity as Context,ArticlesAdapter.IArticle { article ->

          var bundle=Bundle();
          bundle.putString("articleTitleEnglish",article.name);
          bundle.putString("articleTitleHindi",article.hindiName);
      //    Log.d("ART","ART:->"+article.hindiDescription)
          bundle.putString("articleDesHindi",article.hindiDescription);
          bundle.putString("articleDesEnglish",article.description);
          bundle.putString("articleImage",article.imageUrl)
          findNavController().navigate(R.id.viewArticleFragment,bundle)


      },SharedPrefrences.getUserLanguage(activity as Context).equals("hi",true))

        rv_articles.adapter=articleAdapter
        rv_articles.layoutManager=LinearLayoutManager(activity);


    }

    fun onError(msg:String)
    {
        pb.visibility=View.GONE
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



}