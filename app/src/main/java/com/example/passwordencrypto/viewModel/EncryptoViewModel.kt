package com.example.passwordencrypto.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.passwordencrypto.db.CipherEncryptoModel
import com.example.passwordencrypto.repo.EncryptoRepo

class EncryptoViewModel(private val encryptoRepo: EncryptoRepo) : ViewModel() {

    fun addEncryptData(cipherEncryptoModel: CipherEncryptoModel) {
        encryptoRepo.addDataToDB(cipherEncryptoModel)
    }

    fun getDataFromDB(): LiveData<List<CipherEncryptoModel>> {
        return encryptoRepo.getAllDataFromDB()
    }

    fun deleteData(cipherEncryptoModel: CipherEncryptoModel) {
        encryptoRepo.deleteData(cipherEncryptoModel)
    }

    fun deleteAllData(){
        encryptoRepo.deleteAllData()
    }
}