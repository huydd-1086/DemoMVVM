package com.sun.demomvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sun.demomvvm.R
import com.sun.demomvvm.base.BaseAdapter
import com.sun.demomvvm.base.BaseViewHolder
import com.sun.demomvvm.data.model.Product

class ProductAdapter(
    private val onItemClick: (Product) -> Unit
) : BaseAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_product,
                parent,
                false
            ),
            onItemClick
        )
}
