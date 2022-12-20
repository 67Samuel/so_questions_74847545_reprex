package com.example.so_questions_74847545_reprex

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class NavigationFragmentPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private var numPages = 0

    override fun getItemCount(): Int = numPages

    override fun createFragment(position: Int): Fragment {
        return NavigationPageFragment(position)
    }

    fun setNumPages(n: Int) {
        numPages = n
    }
}