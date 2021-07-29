package com.thiagoqueiroz.cartorio.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Certidao::class], version = 1)

abstract class MyDatabase : RoomDatabase() {
    abstract fun certidaoDao() : CertidaoDAO
}

object MyDB {
    fun getInstance(context: Context) : MyDatabase =
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "dados"
        ).allowMainThreadQueries()
         .build()
}