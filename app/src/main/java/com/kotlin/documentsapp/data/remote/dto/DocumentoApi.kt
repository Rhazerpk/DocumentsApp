package com.kotlin.documentsapp.data.remote.dto

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DocumentoApi {

    @GET("documentos")
    suspend fun getDocumento(): List<DocumentoDto>

    @POST("documentos")
    suspend fun postDocumento(@Body clientDto: DocumentoDto): Response<DocumentoDto>

}