package com.sun.demomvvm.ui.favorite

import androidx.navigation.fragment.findNavController
import com.sun.demomvvm.R
import com.sun.demomvvm.base.BaseFragment
import com.sun.demomvvm.data.model.Product
import com.sun.demomvvm.databinding.FragmentFavoriteBinding
import com.sun.demomvvm.ui.adapter.ProductAdapter
import com.sun.demomvvm.utils.showToast
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {

    override val layoutResource get() = R.layout.fragment_favorite

    private val favoriteViewModel by viewModel<FavoriteViewModel>()
    private val adapter = ProductAdapter(this::productClick)

    override fun setupViews() {
    }

    override fun setupData() {
        recyclerFavoriteProducts.adapter = adapter
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            favoriteVM = favoriteViewModel
        }
        observeError()
    }

    override fun setupActions() {
    }

    private fun observeError() = favoriteViewModel.error.observe(viewLifecycleOwner, {
        context?.showToast(it)
    })

    private fun productClick(product: Product) {
        val action = FavoriteFragmentDirections.actionFavoriteToDetail(product)
        findNavController().navigate(action)
    }
}
