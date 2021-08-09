package com.renatojobal.orix.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatojobal.orix.R
import com.renatojobal.orix.CardItemModel
import com.renatojobal.orix.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun RoomDetailScreen(onBackClicked: () -> Unit) {

    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {

        Column {

            // Here goes the sections

            // App bar
            RoomDetailAppBarSection(onBackClicked)

            // Temperature
            TemperatureSection(
                CardItemModel(
                    emoji = "\uD83C\uDF7D",
                    title = "Dining Room",
                    devices = 4,
                    color = PieGreen
                )
            )

            // Devices
            DevicesSection(
                cardItemModels = listOf(
                    CardItemModel(
                        emoji = "\uD83D\uDCA1",
                        title = "Light",
                        devices = 5,
                        color = Selago,
                        on = true
                    ),
                    CardItemModel(
                        emoji = "❄",
                        title = "Cooler",
                        devices = 4,
                        color = FairPink,
                        on = false
                    ),
                    CardItemModel(
                        emoji = "\uD83D\uDCFA",
                        title = "Smart TV",
                        devices = 10,
                        color = AppleGreen,
                        on = false
                    )
                )
            )

        }

    }

}

@Composable
fun RoomDetailAppBarSection(onBackClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "back",
            modifier = Modifier.clickable(onClick = onBackClicked)
        )
        Text(
            text = "Living Room",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .padding(start = 16.dp)

        )
    }

}

@Composable
fun TemperatureSection(currentCardItemModel: CardItemModel) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .padding(horizontal = 40.dp)

    ) {
        // Rounded background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 35.dp)
                .clip(RoundedCornerShape(50))
                .background(Zircon)

        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Circle
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(CircleShape)
                    .background(Muave)
            ) {
                // Circle
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(CircleShape)
                        .background(PureWhite)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Text(
                                text = "21",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h3
                            )
                            Text(
                                text = "ºc",
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.h4
                            )
                        }

                        Text(
                            text = "Room",
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = "Temperature",
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.body1
                        )
                    }


                }


            }


            // Slider
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ) {
                var sliderPosition by remember { mutableStateOf(0f) }
                Slider(
                    value = sliderPosition,
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    onValueChange = {
                        sliderPosition = it
                    },
                    colors = customSliderColors()
                )

            }

            // Temperature
            Text(
                text = "Room temperature",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )

            // Box of temperature with emoji
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(PureWhite)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "\uD83D\uDD25")
                    Text(
                        text = "26 %",
                        fontWeight = FontWeight.Bold, style = MaterialTheme.typography.h6
                    )
                }
            }

        }

    }

}

@Composable
private fun customSliderColors(): SliderColors = SliderDefaults.colors(
    activeTickColor = Color.Transparent,
    inactiveTickColor = Color.Transparent,
    inactiveTrackColor = Color.LightGray,
    activeTrackColor = Color.Black,
    thumbColor = Color.Black
)


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
                    subtitle = if (cardItemModels[it].on) {
                        "on"
                    } else {
                        "off"
                    }
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
        RoomDetailScreen {
            val navController =
                null

        }
    }
}