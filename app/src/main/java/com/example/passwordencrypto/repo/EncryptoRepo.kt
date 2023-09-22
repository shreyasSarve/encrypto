package com.example.passwordencrypto.repo

import androidx.lifecycle.LiveData
import com.example.passwordencrypto.db.DAOEncrypto
import com.example.passwordencrypto.db.CipherEncryptoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EncryptoRepo (var daoEncrypto: DAOEncrypto){

    fun addDataToDB(cipherEncryptoModel: CipherEncryptoModel){
        CoroutineScope(Dispatchers.IO).launch {
            daoEncrypto.addDataToDb(cipherEncryptoModel)
        }
    }

    fun getAllDataFromDB() : LiveData<List<CipherEncryptoModel>>{
        return daoEncrypto.getRoutineData()
    }

    fun deleteData(cipherEncryptoModel: CipherEncryptoModel){
        CoroutineScope(Dispatchers.IO).launch {
            daoEncrypto.deleteData(cipherEncryptoModel)
        }
    }

    fun  deleteAllData(){
        CoroutineScope(Dispatchers.IO).launch {
            daoEncrypto.deleteAllData()
        }
    }
}