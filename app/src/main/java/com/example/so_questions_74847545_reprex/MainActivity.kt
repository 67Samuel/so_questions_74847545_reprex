package com.example.so_questions_74847545_reprex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * The PermissionManager works under the hood with
     * `ActivityCompat.requestPermissions(activity, permissions, code)` i.e. the parent
     * activity request the permission to the system, and receives the request result.
     * We cannot get onRequestPermissionResult called on the fragment using the
     * PermissionManager wrapper. (although the fragment can still be the listener to
     * the PermissionManager if it implements PermissionListener, as the PermissionManager
     * calls the specific callback PermissionListener.onPermissionResult)
     *
     * Workaround: receive the result in the activity on behalf of MapFragment
     *
     * [Issue](https://github.com/mapbox/mapbox-events-android/issues/395)
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        findViewById<FragmentContainerView>(R.id.map_fragment).getFragment<MapFragment>()
            .locationPermissionHelper
            .onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}