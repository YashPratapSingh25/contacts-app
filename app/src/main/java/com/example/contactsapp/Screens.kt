package com.example.contactsapp

sealed class Screens (val route : String) {
    object firstScreen : Screens("FirstScreen")
    object secondScreen : Screens("SecondScreen")
}