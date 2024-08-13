package com.example.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = path.Splash.route ){
        composable(path.Login.route){
            LoginPage(navController=navController,modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0c0c0c)))
        }
        composable(path.SignUp.route){
            Signup(navController=navController,)
        }
        composable(path.Home.route){
            Home(navController=navController,)
        }
        composable(path.AddTask.route){
            AddTask(navController=navController,)
        }
        composable(path.Timer.route){
            mainsecreen(navController=navController,)
        }
        composable(path.Splash.route){
            AnimatedTodoText(navController=navController,)
        }
    }
}