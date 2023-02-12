package com.mercadolibre.melitesttl.application.data.repository.response

sealed class ResponseObject<T: Any> {
    class Loading<T: Any>() : ResponseObject<T>()
    class Success<T:Any>(val data: T) : ResponseObject<T>()
    class Error<T:Any>(code:Int, message: String) : ResponseObject<T>()
}
