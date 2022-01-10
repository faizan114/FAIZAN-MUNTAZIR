package com.example.aroma.fragments

import android.content.ComponentCallbacks
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aroma.R
import com.example.aroma.utility.SharedPrefrences
import kotlinx.android.synthetic.main.fragment_bottomsheet_language_changer.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomsheetLanguageChanger.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomsheetLanguageChanger(langChanged: LanguageChanged) : Fragment() {

    var callback=langChanged;


    interface  LanguageChanged
    {
      fun onlanguageChanged(lang:String);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottomsheet_language_changer, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BottomsheetLanguageChanger.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(callBack:LanguageChanged) =
            BottomsheetLanguageChanger(callBack)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        english.setOnClickListener{
            callback.onlanguageChanged("EN")

        }

        hindi.setOnClickListener {
           callback.onlanguageChanged("HI")
           // dismiss();
        }
    }
}