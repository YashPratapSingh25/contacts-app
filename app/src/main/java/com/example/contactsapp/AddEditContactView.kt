package com.example.contactsapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactsapp.data.Contact

@Composable
fun AddEditContactView(
    id: Int,
    viewModel: ContactViewModel,
    navController: NavController
) {
    val contactState = viewModel.getContact(id).collectAsState(initial = null)
    val contact = contactState.value

    if (id != 0) {
        contact?.let {
            viewModel.contactFirstName = it.firstName
            viewModel.contactLastName = it.lastName
            viewModel.contactNumber = it.number
        }
    } else {
        viewModel.contactFirstName = ""
        viewModel.contactLastName = ""
        viewModel.contactNumber = ""
    }

    Scaffold(
        topBar = {
            TopBar(title = if (id == 0) "Add Contact" else "Update Contact") {
                navController.navigateUp()
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            CustomTextField(
                value = viewModel.contactFirstName,
                label = "First Name",
                onValueChanged = { viewModel.onFirstNameChange(it) }
            )
            CustomTextField(
                value = viewModel.contactLastName,
                label = "Last Name",
                onValueChanged = { viewModel.onLastNameChange(it) }
            )
            CustomTextField(
                value = viewModel.contactNumber,
                label = "Contact Number",
                onValueChanged = { viewModel.onContactNumberChange(it) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.topBarColor),
                        contentColor = Color.White
                    ),
                    onClick = {
                        if (id != 0) {
                            viewModel.updateContact(
                                Contact(
                                    id = id,
                                    firstName = viewModel.contactFirstName,
                                    lastName = viewModel.contactLastName,
                                    number = viewModel.contactNumber
                                )
                            )
                        } else {
                            viewModel.addContact(
                                Contact(
                                    firstName = viewModel.contactFirstName,
                                    lastName = viewModel.contactLastName,
                                    number = viewModel.contactNumber
                                )
                            )
                        }
                        navController.navigateUp()
                    }
                ) {
                    if (id == 0) {
                        Text(text = "Add Contact")
                    } else {
                        Text(text = "Update Contact")
                    }
                }
                if (id != 0 && contact != null) {
                    Button(
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
                            contentColor = Color.White
                        ),
                        onClick = {
                            viewModel.deleteContact(contact)
                            navController.navigateUp()
                        }
                    ) {
                        Text(text = "Delete Contact")
                    }
                }
            }
        }
    }
}


@Composable
fun CustomTextField(value : String, label : String, onValueChanged : (String) -> Unit) {
    val keyboard : KeyboardOptions = if(label == "Contact Number") KeyboardOptions(keyboardType = KeyboardType.Number) else KeyboardOptions(keyboardType = KeyboardType.Text)
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChanged(it) },
        label = { Text(text = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black
        ),
        keyboardOptions = keyboard
    )
}
