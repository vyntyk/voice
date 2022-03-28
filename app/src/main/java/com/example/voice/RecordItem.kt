package com.example.voice

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class RecordItem(@PrimaryKey val id: UUID = UUID.randomUUID(),val title: String, val body: String)
