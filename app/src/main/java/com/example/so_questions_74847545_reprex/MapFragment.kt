package com.example.so_questions_74847545_reprex

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import java.lang.ref.WeakReference

private const val TAG = "MapFragment"
class MapFragment : Fragment(R.layout.fragment_map) {

    private lateinit var map: MapboxMap

    lateinit var locationPermissionHelper: LocationPermissionHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapView = view.findViewById<MapView>(R.id.map_view)
        map = mapView.getMapboxMap()
        // Get the necessary permissions first
        locationPermissionHelper = LocationPermissionHelper(WeakReference(requireActivity()))
        locationPermissionHelper.checkPermissions {
            onMapReady()
        }
    }

    private fun onMapReady() {
        map.loadStyleUri(Style.MAPBOX_STREETS)
    }

}