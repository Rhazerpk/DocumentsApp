package com.kotlin.documentsapp.ui.Document

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.documentsapp.data.repository.DocumentoRepository
import com.kotlin.documentsapp.util.DocumentoListState
import com.kotlin.documentsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DocumentoViewModel @Inject constructor(
    documentoRepository: DocumentoRepository
): ViewModel(){

    private val _uiState = MutableStateFlow(DocumentoListState())
    val uiState: StateFlow<DocumentoListState> = _uiState.asStateFlow()

    init {
        documentoRepository.getDocumentos().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    _uiState.update { it.copy(documentos = result.data ?: emptyList()) }
                }

                is Resource.Error -> {
                    _uiState.update { it.copy(error = result.message ?: "Error desconocido") }
                }
            }
        }.launchIn(viewModelScope)
    }
}