package com.example.so_questions_74847545_reprex

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.from
import com.google.android.material.card.MaterialCardView


class NavigationPageFragment(private val position: Int) :
    Fragment(R.layout.fragment_navigation_page) {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<MaterialCardView>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomSheetBehavior = from(view.findViewById(R.id.bottom_sheet))
        bottomSheetBehavior.apply {
            isHideable = false
            peekHeight = 315
        }

        view.findViewById<TextView>(R.id.text_view).text = "Page $position"
    }

    private fun initBottomSheet() {
//        bottomSheetBehavior = from(requireActivity().findViewById(R.id.bottom_sheet))

        bottomSheetBehavior.apply {
            isHideable = false
            peekHeight = 315
        }

        requireView().findViewById<TextView>(R.id.text_view)

//        bottomSheetCallback = object : BottomSheetCallback() {
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when (newState) {
//                    STATE_EXPANDED -> {
//                        Log.d(TAG, "onStateChanged: STATE_EXPANDED")
//                        isBottomSheetExpanded = true
//                        viewModel.showOnMap(routeLegIndex = position)
//                        viewModel.setMapFabMargin(fabMargin)
//                    }
//                    STATE_COLLAPSED -> {
//                        Log.d(TAG, "onStateChanged: STATE_COLLAPSED")
//
//                        // To let the user know that the bottom sheet does not expand, make the
//                        // state always expanded so that the bottom sheet edges will not be rounded
//                        if (bottomSheetBehavior.peekHeight >= bottomSheetExpandedHeight)
//                            bottomSheetBehavior.state = STATE_EXPANDED
//                        else {
//                            isBottomSheetExpanded = false
//                            viewModel.setMapFabMargin(bottomSheetBehavior.peekHeight)
//                            rootContainer.changeTouchableAreaOfChild(viewPager2, 300)
//                        }
//                    }
//                    else -> {}
//                }
//            }
//        }
//        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
    }

    override fun onStop() {
//        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
        super.onStop()
    }

}