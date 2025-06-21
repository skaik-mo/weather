package com.example.weather.feature_weather.data.repository

import android.Manifest
import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.os.Build
import android.os.Looper
import androidx.annotation.RequiresPermission
import com.example.weather.feature_weather.domain.model.weather.value.LocationModel
import com.example.weather.feature_weather.domain.repository.LocationRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.util.Locale
import kotlin.coroutines.resume
import com.google.android.gms.location.Priority


class GoogleLocationRepository(private val context: Context) : LocationRepository {

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    override suspend fun getCurrentLocation(): LocationModel = withContext(Dispatchers.IO) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

        val androidLocation = getFreshLocation(fusedLocationClient)

        val cityName = getCityName(androidLocation.latitude, androidLocation.longitude)
        LocationModel(
            latitude = androidLocation.latitude,
            longitude = androidLocation.longitude,
            cityName = cityName
        )
    }

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private suspend fun getFreshLocation(client: FusedLocationProviderClient): Location =
        suspendCancellableCoroutine { cont ->
            val request = LocationRequest.create().apply {
                priority = Priority.PRIORITY_HIGH_ACCURACY
                interval = 10_000
                fastestInterval = 5_000
            }

            val callback = object : LocationCallback() {
                override fun onLocationResult(result: LocationResult) {
                    result.lastLocation?.let { location ->
                        cont.resume(location)
                        client.removeLocationUpdates(this)
                    }
                }
            }

            cont.invokeOnCancellation {
                client.removeLocationUpdates(callback)
            }

            client.requestLocationUpdates(
                request,
                callback,
                Looper.getMainLooper()
            )
        }

    private suspend fun getCityName(latitude: Double, longitude: Double): String =
        withContext(Dispatchers.IO) {
            val unknownState = "Unknown State"
            val geocoder = Geocoder(context, Locale.getDefault())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                suspendCancellableCoroutine { cont ->
                    geocoder.getFromLocation(latitude, longitude, 1) { addresses ->
                        val cityName = addresses.firstOrNull()?.adminArea ?: unknownState
                        cont.resume(cityName)
                    }
                }
            } else {
                @Suppress("DEPRECATION")
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                addresses?.firstOrNull()?.adminArea ?: unknownState
            }
        }
}