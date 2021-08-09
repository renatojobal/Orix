package com.renatojobal.orix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.renatojobal.orix.ui.HomeScreen
import com.renatojobal.orix.ui.RoomDetailScreen
import com.renatojobal.orix.ui.theme.OrixTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OrixApp()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun OrixApp() {
    OrixTheme {

        val navController = rememberNavController()
        val backStackEntry = navController.currentBackStackEntryAsState()

        OrixNavHost(
            navController
        )


    }
}

@ExperimentalFoundationApi
@Composable
fun OrixNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxHeight(),
        startDestination = "home"
    ) {
        composable(route="home"){
            HomeScreen { navController.navigate("room-detail") }
        }
        composable(route = "room-detail"){
            RoomDetailScreen { navController.navigate("home") }
        }

    }
}




