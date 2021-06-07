package com.sun.demomvvm.ui.product

import androidx.navigation.fragment.findNavController
import com.sun.demomvvm.R
import com.sun.demomvvm.base.BaseFragment
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.databinding.FragmentProductBinding
import com.sun.demomvvm.ui.adapter.ProductAdapter
import com.sun.demomvvm.utils.showToast
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment<FragmentProductBinding>() {

    override val layoutResource get() = R.layout.fragment_product

    private val productViewModel by viewModel<ProductViewModel>()
    private val adapter = ProductAdapter(this::productClick)

    override fun setupViews() {
    }

    override fun setupData() {
        recyclerProducts.adapter = adapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            productVM = productViewModel
        }
        observeError()
    }

    override fun setupActions() {
    }

    private fun observeError() = productViewModel.error.observe(viewLifecycleOwner, {
        context?.showToast(it)
    })

    private fun productClick(product: Product) {
        val action = ProductFragmentDirections.actionProductToDetail(product)
        findNavController().navigate(action)
    }
}
