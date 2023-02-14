package com.mercadolibre.melitesttl.application.data.repository.response

sealed class ResponseObject<T: Any> {
    class Success<T:Any>(val data: T) : ResponseObject<T>()
    class Error<T:Any>(val code:Int, val message: String) : ResponseObject<T>()
}
