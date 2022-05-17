package com.oliferov.test_for_bearscomgames.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.oliferov.test_for_bearscomgames.data.network.model.NewsDto
import com.oliferov.test_for_bearscomgames.databinding.FragmentNewsFeedBinding
import com.oliferov.test_for_bearscomgames.databinding.NewsItemBinding
import com.squareup.picasso.Picasso

class NewsListAdapter: ListAdapter<NewsDto,NewsListViewHolder>(NewsListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        with(holder.binding){
            with(news){
                Glide.with(holder.binding.root).load(urlToImage).into(ivNews)
                tvAuthor.text = author ?: "-"
                tvPublishedAt.text = publishedAt
                tvTitle.text = title
            }
        }
    }


}

private class NewsListDiffCallback(): DiffUtil.ItemCallback<NewsDto>(){

    override fun areItemsTheSame(oldItem: NewsDto, newItem: NewsDto): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NewsDto, newItem: NewsDto): Boolean {
        return oldItem == newItem
    }


}
