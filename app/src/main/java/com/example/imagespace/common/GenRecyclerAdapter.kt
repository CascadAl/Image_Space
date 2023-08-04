package com.example.imagespace.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.imagespace.BR

abstract class GenViewData

class GenRecyclerAdapter<T : GenViewData>(
    @LayoutRes private val layoutId: Int
) : RecyclerView.Adapter<GenRecyclerAdapter.GenViewHolder>() {

    private val genList = mutableListOf<T>()

    class GenViewHolder(
        private val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun <T> bind(item: T) = with(binding) {
            setVariable(BR.data, item)
            executePendingBindings()
        }

        companion object {
            fun create(parent: ViewGroup, @LayoutRes layoutId: Int): GenViewHolder {
                val binding = DataBindingUtil.inflate<ViewDataBinding>(
                    LayoutInflater.from(parent.context),
                    layoutId,
                    parent,
                    false
                )

                return GenViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenViewHolder =
        GenViewHolder.create(parent, layoutId)

    override fun onBindViewHolder(holder: GenViewHolder, position: Int) {
        holder.bind(genList[position])
    }

    override fun getItemCount(): Int = genList.size

    fun submitList(list: List<T>) {
        genList.addAll(list)
        notifyDataSetChanged()
    }
}