package com.renatojobal.orix.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatojobal.orix.R
import com.renatojobal.orix.Room
import com.renatojobal.orix.ui.theme.*


@ExperimentalFoundationApi
@Composable
fun HomeScreen(
) {
    Box(
        modifier = Modifier
            .background(White)
            .fillMaxSize()
    ) {

        Column {
            // App bar
            AppBarSection()

            // Salute
            GreetingSection(name = "Renato")

            // Rooms
            RoomsSection(
                rooms = listOf(
                    Room(
                        emoji = "\uD83D\uDECB",
                        title = "Living Room",
                        devices = 5,
                        color = PieOrange
                    ),
                    Room(
                        emoji = "\uD83C\uDF73",
                        title = "Kitchen",
                        devices = 4,
                        color = PieYellow
                    ),
                    Room(
                        emoji = "\uD83D\uDDA8",
                        title = "Office",
                        devices = 10,
                        color = PiePurple
                    ),
                    Room(
                        emoji = "\uD83D\uDECC",
                        title = "Bedroom",
                        devices = 6,
                        color = PieBlue
                    ),
                    Room(
                        emoji = "\uD83D\uDEC0",
                        title = "Bathroom",
                        devices = 7,
                        color = PieRed
                    ),
                    Room(
                        emoji = "\uD83C\uDF7D",
                        title = "Dining Room",
                        devices = 4,
                        color = PieGreen
                    )

                )

            )

        }


    }


}


@Composable
fun AppBarSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            tint = MaterialTheme.colors.onSurface,
            contentDescription = "menu",
            modifier = Modifier.size(40.dp, 40.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_group),
            tint = MaterialTheme.colors.onSurface,
            contentDescription = "group",
            modifier = Modifier.size(40.dp, 40.dp)
        )
    }
}


@Composable
fun GreetingSection(name: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hi $name \uD83D\uDC4B",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Wellcome to Orix Home.",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
        }

    }
}


@ExperimentalFoundationApi
@Composable
fun RoomsSection(
    rooms: List<Room>

) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            Row {
                Text(
                    text = "Your",
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = " Rooms",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        IceGreen
                    )
                    .padding(15.dp)
            ) {
                Row {
                    Text(
                        text = "Add ",
                        color = JavaGreen
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_box),
                        tint = JavaGreen,
                        contentDescription = "add"
                    )
                }


            }


        }

        // Rooms grid
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 20.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(rooms.size) {
                RoomItem(room = rooms[it])
            }
        }

    }
}

@Composable
fun RoomItem(
    room: Room
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(30.dp))
            .background(room.color)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
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
                    text = room.emoji,
                    style = MaterialTheme.typography.h5
                )
            }
            Text(
                text = room.title,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${room.devices} devices",
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview("Default preview")
@Composable
fun DefaultPreview() {
    OrixTheme {
        HomeScreen()
    }
}

