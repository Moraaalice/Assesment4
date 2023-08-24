package com.example.assesment.repository

import com.example.assesment.api.ApiClient
import com.example.assesment.api.ApiInterface

class DetailsRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
}