package com.example.contactsapp

import android.app.Application

class ContactsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.initializeDatabase(this)
    }
}