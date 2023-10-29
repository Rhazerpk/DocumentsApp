package com.kotlin.documentsapp.util

import com.kotlin.documentsapp.data.remote.dto.DocumentoDto

data class DocumentoListState(
    val isLoading: Boolean = false,
    val documentos: List<DocumentoDto> = emptyList(),
    val error: String = ""
)
