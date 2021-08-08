package com.renatojobal.orix.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatojobal.orix.R
import com.renatojobal.orix.CardItemModel
import com.renatojobal.orix.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun RoomDetailScreen() {

    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {

        Column {

            // Here goes the sections

            // App bar
            RoomDetailAppBarSection()

            // Temperature
            TemperatureSection(       CardItemModel(
                emoji = "\uD83C\uDF7D",
                title = "Dining Room",
                devices = 4,
                color = PieGreen
            ))

            // Devices
            DevicesSection(
                cardItemModels = listOf(
                    CardItemModel(
                        emoji = "\uD83D\uDECB",
                        title = "Light",
                        devices = 5,
                        color = PieOrange,
                        on = true
                    ),
                    CardItemModel(
                        emoji = "\uD83C\uDF73",
                        title = "Cooler",
                        devices = 4,
                        color = PieYellow,
                        on = false
                    ),
                    CardItemModel(
                        emoji = "\uD83D\uDDA8",
                        title = "Smart TV",
                        devices = 10,
                        color = PiePurple,
                        on = false
                    )
                )
            )

        }

    }

}

@Composable
fun RoomDetailAppBarSection() {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Icon(painter = painterResource(id = R.drawable.ic_arrow_left), contentDescription = "back")
        Text(
            text = "Living Room",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(start = 16.dp)
        )
    }

}

@Composable
fun TemperatureSection(currentCardItemModel: CardItemModel) {
    Text(text = "Temperature: ${currentCardItemModel.temperature}")
}


@ExperimentalFoundationApi
@Composable
fun DevicesSection(
    cardItemModels: List<CardItemModel>

) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            Row {
                Text(
                    text = "Devices",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5,
                )
            }

        }

        // Rooms grid
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 20.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(cardItemModels.size) {
                CardItem(
                    color = cardItemModels[it].color,
                    emoji = cardItemModels[it].emoji,
                    title = cardItemModels[it].title,
                    subtitle = if(cardItemModels[it].on){"on"} else {"off"}
                )
            }
        }

    }
}

@ExperimentalFoundationApi
@Preview("Room detail preview")
@Composable
fun RoomDetailPreview() {
    OrixTheme {
        RoomDetailScreen()
    }
}