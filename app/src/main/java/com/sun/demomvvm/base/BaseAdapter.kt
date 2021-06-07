package com.sun.demomvvm.base

import androidx.recyclerview.widget.RecyclerView
import com.sun.demomvvm.ui.adapter.UpdateData

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder<T>>(), UpdateData<T> {

    private val items = mutableListOf<T>()

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    override fun updateData(data: List<T>?) {
        data?.let {
            this.items.apply {
                clear()
                addAll(it)
            }
            notifyDataSetChanged()
        }
    }
}
