package com.hassan.fakeposts.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hassan.fakeposts.BR
import com.hassan.fakeposts.R
import com.hassan.fakeposts.presentation.viewmodel.home.HomeListener
import com.hassan.fakeposts.presentation.viewmodel.home.PostUiState

class HomeAdapter(
    private var items: List<PostUiState>,
    private val listener: HomeListener
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    fun updateItems(newItems: List<PostUiState>){
        val diffResult = DiffUtil.calculateDiff(HomeDiffUtil(items, newItems))
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_post, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            setVariable(BR.item, items[position])
            setVariable(BR.listener, listener)
        }
    }

    override fun getItemCount(): Int = items.size

    class HomeViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}