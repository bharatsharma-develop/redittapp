package com.example.bharatreddit.viewmodel

import androidx.lifecycle.*
import com.example.bharatreddit.model.CharacterResult
import com.example.bharatreddit.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel(private val repository: Repository): ViewModel() {

    class CharacterProvider(private val repository: Repository):
            ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CharacterViewModel(repository) as T
        }
    }

    private val characterMutableLiveData = MutableLiveData<CharacterResult>()

    fun getCharacterData(): LiveData<CharacterResult> = characterMutableLiveData

    fun requestNextPage(page: Int = 1){
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getNextPage(page)
            withContext(Dispatchers.Main) {
                characterMutableLiveData.value = data
            }
        }
    }
}