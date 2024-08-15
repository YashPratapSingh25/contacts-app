package com.example.contactsapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactsapp.data.Contact

@Composable
fun ContactCard(
    contact : Contact,
    onCardClick : () -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .clickable { onCardClick() },
        backgroundColor = Color.White,
        elevation = 10.dp,
        shape = RectangleShape
    ) {
        Column (
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "${contact.firstName} ${contact.lastName}", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = contact.number, fontSize = 18.sp, color = Color.Gray)
        }
    }
}