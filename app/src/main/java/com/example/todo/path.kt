package com.example.todo

sealed class path(val route:String){
    object SignUp:path("Signup")
    object Login:path("Login")
    object Home:path("Home")
    object AddTask:path("AddTask")
    object Timer:path("timer")
    object Splash:path("splash")
}