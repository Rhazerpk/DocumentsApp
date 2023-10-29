package com.kotlin.documentsapp.data.remote.dto


data class DocumentoDto(
    val Numero: Int,
    val Fecha: String,
    val Tipo: Int,
    val Rnc: String,
    val Ncf: String,
    val VencimientoNcf: String,
    val CodigoCliente: Int,
    val NombreCliente: String,
    val Telefono: String?,
    val TipoNCF: Int,
    val Cantidad: Double,
    val Precio: Double,
    val Descuento: Double,
    val Monto: Double,
    val Efectivo: Double,
    val Cheque: Double,
    val Tarjeta: Double,
    val Latitud: Double,
    val Longitud: Double,
    val ChequeNumero: Int,
    val RetencionISR: Double,
    val IdAlmacen: Int,
    val IdUsuario: Int,
    val MinAppVersion: String,
    val MensajeError: String?
)
