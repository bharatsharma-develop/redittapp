package com.example.bharatreddit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bharatreddit.MainActivity
import com.example.bharatreddit.R
import com.example.bharatreddit.di.CustomApplication
import com.example.bharatreddit.model.CharacterResult
import com.example.bharatreddit.model.Repository
import com.example.bharatreddit.viewmodel.CharacterViewModel
import javax.inject.Inject

class CharacterListFragment: Fragment() {

    private val adapter: CharacterAdapter by lazy {
        CharacterAdapter()
    }

    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var viewModelProvider: CharacterViewModel.CharacterProvider
    @Inject
    lateinit var repository: Repository

    private val viewModel: CharacterViewModel by lazy {
        viewModelProvider.create(CharacterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CustomApplication.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.character_list, container, false)
        recyclerView = view.findViewById(R.id.character_list)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        viewModel.getCharacterData().observe(viewLifecycleOwner){
            updateAdapter(it)
        }

        viewModel.requestNextPage()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        notifyProgressBar(true)
    }

    private fun notifyProgressBar(boolean: Boolean){
        (activity as MainActivity)?.showProgressBar(boolean)
    }

    private fun updateAdapter(it: CharacterResult?) {
        it?.let {
            notifyProgressBar(false)
            adapter.updateData(it)
        }
    }
}