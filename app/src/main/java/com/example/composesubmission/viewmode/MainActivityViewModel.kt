package com.example.composesubmission.viewmode

import androidx.lifecycle.ViewModel
import com.example.composesubmission.data.ComicData
import com.example.composesubmission.model.ItemList
import com.example.composesubmission.model.ItemListURI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivityViewModel : ViewModel() {
    private val comicData = ComicData()

    private val _dataList = MutableStateFlow<List<ItemList>>(comicData.generateData())
    val dataList: StateFlow<List<ItemList>> = _dataList

    private val _dataListUser = MutableStateFlow<List<ItemListURI>>(emptyList())
    val dataListUser: StateFlow<List<ItemListURI>> = _dataListUser
    fun getIndexDataList(index: Int): ItemList = _dataList.value[index]
    fun getIndexDataListUser(index: Int): ItemListURI = _dataListUser.value[index]

    fun getIdDataList(id: Int) = _dataList.value.single { it.id == id }

    fun getIdDataListUser(id: Int) = _dataListUser.value.single { it.id == id }


    fun setFavorite(index: Int) {
        val current = _dataList.value.toMutableList()
        current[index] = ItemList(
            current[index].id,
            current[index].image,
            current[index].title,
            current[index].description,
            current[index].synopsis,
            current[index].genres,
            !current[index].isFavorite
        )
        _dataList.value = current
    }

    fun setFavoriteUser(index: Int) {
        val current = _dataListUser.value.toMutableList()
        current[index] = ItemListURI(
            current[index].id,
            current[index].image,
            current[index].bitmap,
            current[index].title,
            current[index].description,
            current[index].synopsis,
            current[index].genres,
            !current[index].isFavorite
        )
        _dataListUser.value = current
    }


    fun addFirstDataListUser(data: ItemListURI) {
        val current = _dataListUser.value.toMutableList()
        current.add(0, data)
        _dataListUser.value = current
    }

    fun editCurrentDataListUser(index: Int, title: String, description: String) {
        val current = _dataListUser.value.toMutableList()
        current[index] = ItemListURI(
            current[index].id,
            current[index].image,
            current[index].bitmap,
            title,
            description,
            current[index].synopsis,
            current[index].genres,
            current[index].isFavorite
        )
        _dataListUser.value = current
    }
    fun editCurrentDataList(index: Int, title: String, description: String) {
        val current = _dataList.value.toMutableList()
        current[index] = ItemList(
            current[index].id,
            current[index].image,
            title,
            description,
            current[index].synopsis,
            current[index].genres,
            current[index].isFavorite
        )
        _dataList.value = current
    }

    fun deleteCurrentDataListUser(index: Int) {
        val current = _dataListUser.value.toMutableList()
        current.removeAt(index)
        _dataListUser.value = current
    }

    fun deleteCurrentDataList(index: Int) {
        val current = _dataList.value.toMutableList()
        current.removeAt(index)
        _dataList.value = current
    }

}