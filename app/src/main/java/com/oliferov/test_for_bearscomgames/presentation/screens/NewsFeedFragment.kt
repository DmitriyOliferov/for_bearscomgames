package com.oliferov.test_for_bearscomgames.presentation.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.oliferov.test_for_bearscomgames.databinding.FragmentNewsFeedBinding
import com.oliferov.test_for_bearscomgames.presentation.adapter.NewsListAdapter
import com.oliferov.test_for_bearscomgames.presentation.viewmodels.NewsViewModel
import java.lang.RuntimeException

class NewsFeetFragment : Fragment() {

    private var _binding: FragmentNewsFeedBinding? = null
    private val binding: FragmentNewsFeedBinding
        get() = _binding ?: throw RuntimeException("NewsFeetFragment is null")

    private lateinit var viewModel: NewsViewModel

    private lateinit var newsListAdapter: NewsListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRv()
        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getAllNews()
        viewModel.newsList.observe(this) {
            newsListAdapter.submitList(it)
        }
    }

    fun setupRv() {
        newsListAdapter = NewsListAdapter()

        binding.rvNews.apply {
            adapter = newsListAdapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFeetFragment()
    }
}
