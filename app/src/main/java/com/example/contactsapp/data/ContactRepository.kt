package com.example.contactsapp.data

import kotlinx.coroutines.flow.Flow

class ContactRepository (private val contactDao: ContactDao) {

    suspend fun addContact(contact: Contact){
        contactDao.addContact(contact)
    }

    suspend fun updateContact(contact: Contact){
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact){
        contactDao.deleteContact(contact)
    }

    fun getAllContacts() : Flow<List<Contact>> = contactDao.getAllContacts()

    fun getContact(id : Int) : Flow<Contact> = contactDao.getContact(id)
}