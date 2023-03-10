package com.mercadolibre.test.data.model

import com.google.gson.annotations.SerializedName


data class Results (

    @SerializedName("id") val id : String,
    @SerializedName("title") val title : String,
    @SerializedName("condition") val condition : String,
    @SerializedName("thumbnail_id") val thumbnail_id : String,
    @SerializedName("catalog_product_id") val catalog_product_id : String,
    @SerializedName("listing_type_id") val listing_type_id : String,
    @SerializedName("permalink") val permalink : String,
    @SerializedName("buying_mode") val buying_mode : String,
    @SerializedName("site_id") val site_id : String,
    @SerializedName("category_id") val category_id : String,
    @SerializedName("domain_id") val domain_id : String,
    @SerializedName("variation_id") val variation_id : String,
    @SerializedName("thumbnail") val thumbnail : String,
    @SerializedName("currency_id") val currency_id : String,
    @SerializedName("order_backend") val order_backend : Int,
    @SerializedName("price") val price : Double,
    @SerializedName("original_price") val original_price : String,
    @SerializedName("sale_price") val sale_price : String,
    @SerializedName("sold_quantity") val sold_quantity : Int,
    @SerializedName("available_quantity") val available_quantity : Int,
    @SerializedName("official_store_id") val official_store_id : String,
    @SerializedName("use_thumbnail_id") val use_thumbnail_id : Boolean,
    @SerializedName("accepts_mercadopago") val accepts_mercadopago : Boolean,
    @SerializedName("tags") val tags : List<String>,
    @SerializedName("variation_filters") val variation_filters : List<String>,
    @SerializedName("stop_time") val stop_time : String,
    @SerializedName("winner_item_id") val winner_item_id : String,
    @SerializedName("discounts") val discounts : String,
    @SerializedName("promotions") val promotions : List<String>,
    @SerializedName("inventory_id") val inventory_id : String
)
