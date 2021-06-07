package com.sun.demomvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<F : ViewDataBinding> : Fragment() {

    @get: LayoutRes
    protected abstract val layoutResource: Int
    protected var binding: F? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil
        .inflate<F>(inflater, layoutResource, container, false)
        .apply { binding = this }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupData()
        setupActions()
    }

    protected abstract fun setupViews()

    protected abstract fun setupData()

    protected abstract fun setupActions()

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
