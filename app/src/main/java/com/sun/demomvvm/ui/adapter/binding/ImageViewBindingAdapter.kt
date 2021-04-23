package com.sun.demomvvm.ui.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.sun.demomvvm.utils.loadImage

@BindingAdapter("app:image")
fun loadImage(imageView: ImageView, url: String?) {
    imageView.loadImage(url)
}
