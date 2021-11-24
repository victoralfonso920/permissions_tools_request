package com.victordevs.permissiontool.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

// Created by Victor Hernandez on 24/11/21.
// Proyect Permission Tool
//contact victoralfonso920@gmail.com

 fun Context.openSettings() {
    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        addCategory(Intent.CATEGORY_DEFAULT)
        data = Uri.parse("package:$packageName")
    }.let(::startActivity)
}

fun FragmentActivity.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}