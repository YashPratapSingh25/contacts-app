package com.example.contactsapp

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun TopBar(
    title : String,
    onNavIconClick : () -> Unit = {}
) {

    val navigationIcon : @Composable (() -> Unit)? = if(title != "Contacts"){
        {
            IconButton(onClick = { onNavIconClick() }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        }
    }else{
        null
    }

    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = navigationIcon,
        backgroundColor = colorResource(id = R.color.topBarColor),
        contentColor = Color.White,
        elevation = 10.dp
    )
}