package com.example.so_questions_74847545_reprex

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

private const val TAG = "NavigationFragment"

class NavigationFragment : Fragment(R.layout.fragment_navigation) {

    private lateinit var pageAdapter: NavigationFragmentPageAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pageAdapter = NavigationFragmentPageAdapter(this).apply {
            setNumPages(3)
            view.findViewById<ViewPager2>(R.id.view_pager).adapter = this
        }
    }

}