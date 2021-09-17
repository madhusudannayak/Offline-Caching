package com.example.offlinecaching.features.restaurant

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.offlinecaching.api.RestaurantApi
import com.example.offlinecaching.data.Restaurant
import com.example.offlinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
  //      api: RestaurantApi,
        repository: RestaurantRepository
) : ViewModel() {
    val restaurant = repository.getRestaurant().asLiveData()




//    private val restaurantLiveData = MutableLiveData<List<Restaurant>>()
//    val restaurant: LiveData<List<Restaurant>> = restaurantLiveData
//
//    init {
//        viewModelScope.launch {
//            val restaurants = api.getRestaurants()
//            delay(2000)
//            restaurantLiveData.value = restaurants
//        }
//
//    }

}