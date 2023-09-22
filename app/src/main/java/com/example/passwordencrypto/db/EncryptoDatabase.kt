package com.example.passwordencrypto.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CipherEncryptoModel::class], version = 2, exportSchema = false)
abstract class EncryptoDatabase  : RoomDatabase() {
    abstract fun getEncryptedData() : DAOEncrypto

    companion object {
        private var INSTANCE : EncryptoDatabase? = null

        fun getDatabaseObject(context: Context)  : EncryptoDatabase {
            if (INSTANCE != null){
                return  INSTANCE!!
            }else {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    EncryptoDatabase::class.java,
                    "encrypto.db"
                )
                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()
            }
            return INSTANCE!!
        }
    }
}