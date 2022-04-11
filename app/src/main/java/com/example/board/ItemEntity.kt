package com.example.board

import com.squareup.moshi.Json

data class ItemEntity(
    @field:Json(name = "number")
    var number: Long?,
    @field:Json(name = "title")
    var title: String?,
    @field:Json(name = "nickname")
    var nickname: String?,
    @field:Json(name = "content")
    var content: String?
)