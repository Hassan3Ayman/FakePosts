package com.hassan.fakeposts.presentation.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.hassan.fakeposts.presentation.viewmodel.home.PostUiState

class HomeDiffUtil(
    private val oldList: List<PostUiState>,
    private val newList: List<PostUiState>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].equals(newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}