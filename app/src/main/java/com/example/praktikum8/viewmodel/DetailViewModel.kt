package com.example.praktikum8.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum8.modeldata.DataSiswa
import com.example.praktikum8.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import retrofit2.Response


sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}


