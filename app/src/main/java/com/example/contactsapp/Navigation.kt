package com.example.contactsapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val viewModel : ContactViewModel = viewModel()
    
    NavHost(
        navController = navController,
        startDestination = Screens.firstScreen.route
    ){
        composable(Screens.firstScreen.route){
            HomeView(viewModel, navController){
                navController.navigate(Screens.secondScreen.route + "/0")
            }
        }

        composable(
            route = Screens.secondScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id"){
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ){
            val id = it.arguments!!.getInt("id")
            AddEditContactView(id = id, viewModel = viewModel, navController = navController)
        }
    }
}