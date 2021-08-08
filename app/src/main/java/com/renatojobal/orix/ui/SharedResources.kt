package com.renatojobal.orix.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.renatojobal.orix.CardItemModel
import com.renatojobal.orix.ui.theme.PieOrange
import com.renatojobal.orix.ui.theme.White


@Composable
fun CardItem(
    color: Color,
    emoji: String,
    title: String,
    subtitle: String,
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(30.dp))
            .background(color)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.wrapContentHeight()
        )
        {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        White
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = emoji,
                    style = MaterialTheme.typography.h5
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Preview("Default preview")
@Composable
fun CardItemPreview() {
    CardItem(
        emoji = "\uD83D\uDECB",
        title = "Light",
        color = PieOrange,
        subtitle = "5 devices"
    )

}