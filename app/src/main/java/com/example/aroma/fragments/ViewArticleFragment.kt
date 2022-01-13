package com.example.aroma.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.aroma.R
import com.example.aroma.utility.SharedPrefrences
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_view_article.*
import kotlinx.android.synthetic.main.toolbar.view.*

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
        Picasso.get().load(args.articleImage).into(article_image);

        if(SharedPrefrences.getUserLanguage(activity as Context).equals("hi",true))
        {
            toolbar_view_article.searchIcon.visibility=View.GONE;
            toolbar_view_article.toolbar_title.text=args.articleTitleHindi
            article_text.text=args.articleDesHindi;

        }
         else
         {
             toolbar_view_article.toolbar_title.text=args.articleTitleEnglish
            article_text.text=args.articleDesEnglish;

           }

        toolbar_view_article.toolbar_backIcon.setOnClickListener { (activity)?.onBackPressed() }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewArticleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewArticleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}