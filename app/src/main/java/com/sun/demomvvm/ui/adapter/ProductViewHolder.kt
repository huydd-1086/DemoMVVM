package com.sun.demomvvm.ui.adapter

import com.sun.demomvvm.base.BaseViewHolder
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.databinding.ItemProductBinding

class ProductViewHolder(
    private val itemProductBinding: ItemProductBinding,
    onItemClick: (Product) -> Unit
) : BaseViewHolder<Product>(itemProductBinding, onItemClick) {

    override fun bindData(item: Product) {
        super.bindData(item)
        itemProductBinding.product = item
    }
}
