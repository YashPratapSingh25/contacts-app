package com.example.contactsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactsapp.data.Contact
import com.example.contactsapp.data.ContactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ContactViewModel(
    val contactRepository: ContactRepository = Graph.contactRepository
) : ViewModel() {
    var contactFirstName by mutableStateOf("")
    var contactLastName by mutableStateOf("")
    var contactNumber by mutableStateOf("")

    fun onFirstNameChange(newString : String){
        contactFirstName = newString
    }

    fun onLastNameChange(newString : String){
        contactLastName = newString
    }

    fun onContactNumberChange(newString : String){
        contactNumber = newString
    }

    fun addContact(contact : Contact){
        viewModelScope.launch {
            contactRepository.addContact(contact)
        }
    }

    fun updateContact(contact : Contact){
        viewModelScope.launch {
            contactRepository.updateContact(contact)
        }
    }

    fun deleteContact(contact : Contact){
        viewModelScope.launch {
            contactRepository.deleteContact(contact)
        }
    }

    fun getContact(id : Int) : Flow<Contact>{
        return contactRepository.getContact(id)
    }

    fun getAllContacts() : Flow<List<Contact>>{
        return contactRepository.getAllContacts()
    }
}