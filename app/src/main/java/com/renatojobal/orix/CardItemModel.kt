package com.renatojobal.orix

import androidx.compose.ui.graphics.Color

data class CardItemModel(
    val emoji: String,
    val title: String,
    val devices: Int,
    val color: Color,
    var temperature : Float = 0f,
    var on: Boolean = false
) {

}
