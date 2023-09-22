package com.example.passwordencrypto.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Encrypted")

data class CipherEncryptoModel(
    @ColumnInfo(name = "data") var data: String,
    @ColumnInfo(name = "key") var key: Int,
    @ColumnInfo(name = "technique") var technique: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}
