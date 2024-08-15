package com.example.contactsapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name = "FirstName")
    val firstName : String = "",
    @ColumnInfo(name = "LastName")
    val lastName : String = "",
    @ColumnInfo(name = "Number")
    val number : String = ""
)