package com.example.weather.feature_weather.data.repository

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.os.Build
import androidx.annotation.RequiresPermission
import com.example.weather.feature_weather.domain.model.Location
import com.example.weather.feature_weather.domain.repository.LocationRepository
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import android.location.Location as AndroidLocation

class GoogleLocationRepository(private val context: Context) : LocationRepository {

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): Location = withContext(Dispatchers.IO) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        val androidLocation = suspendCancellableCoroutine<AndroidLocation?> { cont ->
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location ->
                    cont.resume(location)
                }
                .addOnFailureListener { exception ->
                    cont.resumeWithException(exception)
                }
        }

        if (androidLocation == null) {
            throw Exception("Location is null")
        }

        val cityName = try {
            getCityName(androidLocation.latitude, androidLocation.longitude)
        } catch (e: Exception) {
            throw Exception("Unknown State")
        }

        Location(
            latitude = androidLocation.latitude,
            longitude = androidLocation.longitude,
            cityName = cityName,
        )
    }

    private suspend fun getCityName(latitude: Double, longitude: Double): String =
        withContext(Dispatchers.IO) {
            val geocoder = Geocoder(context, Locale.getDefault())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                suspendCancellableCoroutine { cont ->
                    geocoder.getFromLocation(latitude, longitude, 1) { addresses ->
                        val cityName = addresses.firstOrNull()?.adminArea ?: "Unknown State"
                        cont.resume(cityName)
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                addresses?.firstOrNull()?.adminArea ?: "Unknown State"
            }
        }
}