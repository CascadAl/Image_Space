package com.example.imagespace.common.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.imagespace.BR

class GenPagingAdapter<T : GenPagingViewData>(
    @LayoutRes private val layoutId: Int
) :
    PagingDataAdapter<T, GenPagingAdapter.GenPagingViewHolder>(GenPagingDiffCallback()) {

    class GenPagingViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun <T> bind(item: T) = with(binding) {
            setVariable(BR.data, item)
            executePendingBindings()
        }

        companion object {
            fun create(
                parent: ViewGroup,
                @LayoutRes layoutId: Int
            ): GenPagingViewHolder {
                val binding = DataBindingUtil.inflate<ViewDataBinding>(
                    LayoutInflater.from(parent.context),
                    layoutId,
                    parent,
                    false
                )

                return GenPagingViewHolder(binding)
            }
        }
    }

    private class GenPagingDiffCallback<T : GenPagingViewData> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenPagingViewHolder =
        GenPagingViewHolder.create(parent, layoutId)

    override fun onBindViewHolder(holder: GenPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}