package com.sun.demomvvm.ui.detail

import androidx.navigation.fragment.navArgs
import com.sun.demomvvm.R
import com.sun.demomvvm.base.BaseFragment
import com.sun.demomvvm.databinding.FragmentDetailBinding
import com.sun.demomvvm.utils.showToast
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override val layoutResource get() = R.layout.fragment_detail

    private val detailViewModel by viewModel<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun setupViews() {
    }

    override fun setupData() {
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            product = args.product
            detailVM = detailViewModel
        }
        observeError()
        detailViewModel.checkFavorite(args.product.id)
    }

    override fun setupActions() {
        buttonFavorite.setOnClickListener {
            detailViewModel.setFavorite(args.product)
        }
    }

    private fun observeError() = detailViewModel.error.observe(viewLifecycleOwner, {
        context?.showToast(it)
    })
}
