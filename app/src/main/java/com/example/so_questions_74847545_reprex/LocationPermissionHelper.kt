package com.example.so_questions_74847545_reprex

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.mapbox.android.core.permissions.PermissionsListener
import com.mapbox.android.core.permissions.PermissionsManager
import java.lang.ref.WeakReference

private const val TAG = "LocationPermissionHelpr"

class LocationPermissionHelper(weakReference: WeakReference<Activity>) {
    private lateinit var permissionsManager: PermissionsManager
    private val activity = weakReference.get()

    fun checkPermissions(onMapReady: () -> Unit) {
        if (activity == null)
            Log.e(TAG, "weakReference did not yield activity")
        if (PermissionsManager.areLocationPermissionsGranted(activity)) {
            onMapReady()
        } else {
            permissionsManager = PermissionsManager(object : PermissionsListener {
                override fun onExplanationNeeded(permissionsToExplain: List<String>) {
                    Toast.makeText(
                        activity,
                        "You need to allow location permissions to navigate",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onPermissionResult(granted: Boolean) {
                    if (granted) {
                        onMapReady()
                    } else {
                        activity?.finish()
                    }
                }
            })
            permissionsManager.requestLocationPermissions(activity)
        }
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}