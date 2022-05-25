package com.example.whatthedogdoin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whatthedogdoin.db.dao.DogDao
import com.example.whatthedogdoin.db.dao.CategoryDao
import com.example.whatthedogdoin.db.dao.DiseaseDao
import com.example.whatthedogdoin.db.entities.Breed
import com.example.whatthedogdoin.db.entities.Category
import com.example.whatthedogdoin.db.entities.Dog
import com.example.whatthedogdoin.db.entities.Disease
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(
    entities = [
        Category::class,
        Dog::class,
        Breed::class,
        Disease::class,
    ], version = 1, exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class WhatTheDogDoinRoomDatabase : RoomDatabase() {

    // DAOs
    abstract fun dogDao(): DogDao
    abstract fun categoryDao(): CategoryDao
    abstract fun diseaseDao(): DiseaseDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WhatTheDogDoinRoomDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): WhatTheDogDoinRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WhatTheDogDoinRoomDatabase::class.java,
                    "WhatTheDogDoinBase.db"
                )
                    .createFromAsset("database/WhatTheDogDoinBase.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}