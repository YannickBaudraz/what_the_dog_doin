package com.example.whatthedogdoin

import android.app.Application
import com.example.whatthedogdoin.db.WhatTheDogDoinRoomDatabase
import com.example.whatthedogdoin.repositories.BreedRepository
import com.example.whatthedogdoin.repositories.CategoryRepository
import com.example.whatthedogdoin.repositories.ClientRepository
import com.example.whatthedogdoin.repositories.DogRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WhatTheDogDoinApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WhatTheDogDoinRoomDatabase.getDatabase(this, applicationScope) }
    val clientRepository by lazy { ClientRepository(database.clientDao()) }
    val breedRepository by lazy { BreedRepository(database.breedDao()) }
    val categoryRepository by lazy { CategoryRepository(database.categoryDao()) }
    val dogRepository by lazy { DogRepository(database.dogDao()) }
}