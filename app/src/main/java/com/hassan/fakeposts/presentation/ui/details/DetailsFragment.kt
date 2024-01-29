package com.hassan.fakeposts.presentation.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hassan.fakeposts.BR
import com.hassan.fakeposts.R
import com.hassan.fakeposts.databinding.FragmentDetailsBinding
import com.hassan.fakeposts.presentation.viewmodel.details.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var _binding: FragmentDetailsBinding
    private val binding: FragmentDetailsBinding
        get() = _binding

    private val detailsViewModel: DetailsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, detailsViewModel)
            return root
        }
    }

}