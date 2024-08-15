package com.example.contactsapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactsapp.data.Contact

@Composable
fun HomeView(
    viewModel: ContactViewModel,
    navController: NavController,
    onButtonClick : () -> Unit = {}
) {
    
    
    Scaffold (
        topBar = { TopBar(title = "Contacts") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onButtonClick() },
                backgroundColor = colorResource(id = R.color.topBarColor),
                contentColor = Color.White,
                modifier = Modifier.padding(20.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
            }
        }
    ) {
        val contactList = viewModel.getAllContacts().collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier.fillMaxSize().padding(it)){
            items(contactList.value){
                ContactCard(contact = it){
                    navController.navigate(Screens.secondScreen.route + "/${it.id}")
                }
            }
        }

    }
}