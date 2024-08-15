package com.example.contactsapp

import android.content.Context
import androidx.room.Room
import com.example.contactsapp.data.ContactDatabase
import com.example.contactsapp.data.ContactRepository

object Graph {
    lateinit var database : ContactDatabase

    val contactRepository by lazy{
        ContactRepository(database.contactDao())
    }

    fun initializeDatabase(context: Context){
        database = Room.databaseBuilder(context = context, klass = ContactDatabase::class.java, name = "contact-db").build()
    }
}