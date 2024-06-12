package br.com.fiap.locamail.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuScreenViewModel: ViewModel() {

    private val _searchText = MutableLiveData<String>()
    var searchText: LiveData<String> = _searchText

    fun onSearchTextChang(inputedSearchText: String){
        _searchText.value = inputedSearchText
    }
}