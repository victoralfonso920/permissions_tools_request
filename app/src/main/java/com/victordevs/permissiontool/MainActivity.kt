package com.victordevs.permissiontool

import android.Manifest.permission.*
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.victordevs.permissiontool.extensions.toast
@RequiresApi(Build.VERSION_CODES.M)

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnRequest).setOnClickListener {
            requestPermission()
        }
    }
    private fun requestPermission(){
        coarseLocation.runWithPermission {
            toast("Success")
        }
    }

    private val coarseLocation = PermissionRequester(this, CAMERA,
        onDenied = { toast("Permission Denied") },
        onShowRationale = { toast("Should show Rationale") })
}