package com.example.passwordencrypto.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAOEncrypto {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataToDb(cipherEncryptoModel: CipherEncryptoModel)

    @Query("delete from `encrypted` ")
    fun deleteAllData()

    @Query("select * from `encrypted` order by id desc ")
    fun getRoutineData(): LiveData<List<CipherEncryptoModel>>

    @Delete
    fun deleteData(cipherEncryptoModel: CipherEncryptoModel)

}