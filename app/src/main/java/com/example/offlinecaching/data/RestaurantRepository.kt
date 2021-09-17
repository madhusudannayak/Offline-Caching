package com.example.offlinecaching.data

import androidx.room.withTransaction
import com.example.offlinecaching.api.RestaurantApi
import com.example.offlinecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
        val api: RestaurantApi,
        private val db: RestaurantDatabase
) {
    private val restaurantDao = db.restaurantDao()

    fun getRestaurant() = networkBoundResource(
            query = {
                restaurantDao.getAllRestaurants()
            },
            fetch = {
                delay(2000)
                api.getRestaurants()
            },
            saveFetchResult = { restaurant ->
                db.withTransaction {
                    restaurantDao.deleteAllRestaurants()
                    restaurantDao.insertRestaurants(restaurant)
                }
            }
    )
}