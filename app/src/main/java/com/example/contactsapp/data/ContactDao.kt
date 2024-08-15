package com.example.contactsapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ContactDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun addContact(contactEntity : Contact)

    @Update
    abstract suspend fun updateContact(contactEntity: Contact)

    @Delete
    abstract suspend fun deleteContact(contactEntity: Contact)

    @Query("SELECT * FROM contact ORDER BY FirstName ASC")
    abstract fun getAllContacts() : Flow<List<Contact>>

    @Query("SELECT * FROM contact WHERE id = :id")
    abstract fun getContact(id : Int) : Flow<Contact>
}