package com.victordevs.permissiontool

import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity

// Created by Victor Hernandez on 24/11/21.
// Proyect Permission Tool
//contact victoralfonso920@gmail.com
@RequiresApi(Build.VERSION_CODES.M)

class PermissionRequester(
    activity: FragmentActivity,
    private val permission: String,
    onDenied: () -> Unit = {},
    onShowRationale: () -> Unit = {}
) {
    private var onGranted: () -> Unit = {}
    private val launcher =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            when {
                isGranted -> onGranted()
                activity.shouldShowRequestPermissionRationale(permission) -> onShowRationale()
                else -> onDenied()
            }
        }

    fun runWithPermission(onGranted: () -> Unit) {
        this.onGranted = onGranted
        launcher.launch(permission)
    }
}