package com.example.board

import java.io.Serializable

class ItemEntity:Serializable{
    var number: Long? = null
    var title: String? = null
    var nickname: String? = null
    var content: String? = null
}