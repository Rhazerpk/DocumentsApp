package com.kotlin.documentsapp.data.repository

import com.kotlin.documentsapp.data.remote.dto.DocumentoApi
import com.kotlin.documentsapp.data.remote.dto.DocumentoDto
import com.kotlin.documentsapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DocumentoRepository @Inject constructor(
    private val api: DocumentoApi
) {

    fun getDocumentos(): Flow<Resource<List<DocumentoDto>>> = flow {
        try {
            emit(Resource.Loading())

            val client = api.getDocumento()

            emit(Resource.Success(client))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error HTTP GENERAL"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar tu conexión a internet"))
        }
    }

    suspend fun postDocumento(documento: DocumentoDto) = api.postDocumento(documento)
}