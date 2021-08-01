package com.renatojobal.orix.ui

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renatojobal.orix.R
import com.renatojobal.orix.ui.theme.LightGreen
import com.renatojobal.orix.ui.theme.OrixTheme
import com.renatojobal.orix.ui.theme.White


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
            RoomsSection()

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
                text = "Hi $name",
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "Welcome to Orix Home.",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(0.dp, 10.dp)
            )
        }

    }
}


@Composable
fun RoomsSection() {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            Text(
                text = "Your Rooms",
                style = MaterialTheme.typography.h4
            )
            Row (
                modifier = Modifier
                    .padding(20.dp)
                    .background(LightGreen)
                    .clip(RoundedCornerShape(4.dp))
                    ){
                Text(
                    text = "Add",

                )

            }

        }
    }
}


@Preview("Default preview")
@Composable
fun DefaultPreview() {
    OrixTheme {
        HomeScreen()
    }
}

