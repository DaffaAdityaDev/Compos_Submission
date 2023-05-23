package com.example.composesubmission.viewmode

import androidx.lifecycle.ViewModel
import com.example.composesubmission.model.ItemList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel : ViewModel() {

    private val _dataList = MutableStateFlow<List<ItemList>>(emptyList())
    val dataList: StateFlow<List<ItemList>> = _dataList

    fun setDataList(data: List<ItemList>) {
        _dataList.value = data
    }

    fun addFirstDataList(data: ItemList) {
        val current = _dataList.value.toMutableList()
        current.add(0, data)
        _dataList.value = current
    }

    fun editCurrentDataList(data: ItemList) {

    }

}