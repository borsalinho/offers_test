package com.tests.offerstest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tests.domain.usecases.GetOffersUseCase
import com.tests.offerstest.mappers.toOffersViewData
import com.tests.offerstest.models.OffersViewData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SearchViewModel(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offers = MutableLiveData<OffersViewData>()
    private val offers: LiveData<OffersViewData> get() = _offers

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchOffers() {
        viewModelScope.launch {
            try {
                val result = getOffersUseCase.execute().toOffersViewData()
                _offers.value = result
                System.out.println(offers.value.toString())
            } catch (e: HttpException) {
                _error.value = "Ошибка сети: ${e.message()}"
            } catch (e: IOException) {
                _error.value = "Ошибка ввода-вывода: ${e.message}"
            } catch (e: Exception) {
                _error.value = "Не удалось загрузить данные: ${e.message}"
            }
        }
    }
}