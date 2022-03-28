package com.example.voice.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.voice.RecordItem

@Database(entities = [RecordItem::class], version=1)

@TypeConverters(TypeConverters::class)
abstract class DataBase : RoomDatabase(){
    abstract fun Dao(): Dao
}