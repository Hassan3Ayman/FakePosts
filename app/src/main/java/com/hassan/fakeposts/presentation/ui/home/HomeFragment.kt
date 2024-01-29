package com.hassan.fakeposts.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.hassan.fakeposts.R
import com.hassan.fakeposts.databinding.FragmentHomeBinding
import com.hassan.fakeposts.presentation.viewmodel.home.HomeListener
import com.hassan.fakeposts.presentation.viewmodel.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeListener {

    private lateinit var _binding: FragmentHomeBinding
    private val binding: FragmentHomeBinding
        get() = _binding

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        _binding.apply {
            lifecycleOwner = viewLifecycleOwner
            return root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        collectChange()
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter(mutableListOf(), this)
        binding.postsRecyclerView.adapter = homeAdapter
    }

    private fun collectChange(){
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                homeViewModel.state.collect{
                    homeAdapter.updateItems(it.posts)
                }
            }
        }
    }

    override fun onPostClick(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailsFragment(id)
        )
    }

}