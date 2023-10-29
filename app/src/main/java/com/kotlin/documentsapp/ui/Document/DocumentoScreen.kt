package com.kotlin.documentsapp.ui.Document

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotlin.documentsapp.data.remote.dto.DocumentoDto


@Composable
fun DocumentoScreen(viewModel: DocumentoViewModel = hiltViewModel()){
    val uiState by viewModel.uiState.collectAsState()

    uiState.documentos?.let { documento ->
        Consult(documento)
    }
}



@Composable
fun Consult(documentos: List<DocumentoDto>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Lista de documentos", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(documentos) { documento ->
                DocumentoItem(documento)
            }
        }
    }
}

@Composable
fun DocumentoItem(documento: DocumentoDto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Número: " + documento.Numero.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Fecha: " + documento.Fecha, style = MaterialTheme.typography.titleMedium)
            Text(text = "Tipo: " + documento.Tipo.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Rnc: " + documento.Rnc, style = MaterialTheme.typography.titleMedium)
            Text(text = "Ncf: " + documento.Ncf, style = MaterialTheme.typography.titleMedium)
            Text(text = "VencimientoNcf: " + documento.VencimientoNcf, style = MaterialTheme.typography.titleMedium)
            Text(text = "CodigoCliente: " + documento.CodigoCliente.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "NombreCliente: " + documento.NombreCliente, style = MaterialTheme.typography.titleMedium)
            Text(text = "Telefono: " + (documento.Telefono ?: "N/A"), style = MaterialTheme.typography.titleMedium)
            Text(text = "TipoNCF: " + documento.TipoNCF.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Cantidad: " + documento.Cantidad.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Precio: " + documento.Precio.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Descuento: " + documento.Descuento.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Monto: " + documento.Monto.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Efectivo: " + documento.Efectivo.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Cheque: " + documento.Cheque.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Tarjeta: " + documento.Tarjeta.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Latitud: " + documento.Latitud.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Longitud: " + documento.Longitud.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "ChequeNumero: " + documento.ChequeNumero.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "RetencionISR: " + documento.RetencionISR.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "IdAlmacen: " + documento.IdAlmacen.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "IdUsuario: " + documento.IdUsuario.toString(), style = MaterialTheme.typography.titleMedium)
            Text(text = "MinAppVersion: " + documento.MinAppVersion, style = MaterialTheme.typography.titleMedium)
            Text(text = "MensajeError: " + (documento.MensajeError ?: "N/A"), style = MaterialTheme.typography.titleMedium)
        }
    }
}