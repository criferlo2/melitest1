package com.mercadolibre.melitesttl.application.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercadolibre.melitesttl.application.data.repository.response.ResponseObject
import com.mercadolibre.test.data.model.ResultList
import com.mercadolibre.test.data.model.Results
import com.mercadolibre.test.data.repository.IProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Scope

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: IProductRepository
) : ViewModel() {

    var productsLiveData = MutableLiveData<List<Results>>()


    fun getSomething(): String {
        return "puta lo hice"
    }

    fun getSomethingFromRepo() = productRepository.getSomethingOfRepository()

    fun getProducts(text: String) {
        viewModelScope.launch {
            when (val products = productRepository.getProducts(text)) {
                is ResponseObject.Success -> {
                    val resultList = (products.data as ResultList).results
                    productsLiveData.postValue(resultList)
                    Timber.d("success %s", resultList.size)
                }
                is ResponseObject.Error -> Timber.d("error", "error")
            }
        }
    }
}