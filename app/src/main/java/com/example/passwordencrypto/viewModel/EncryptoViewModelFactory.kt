package com.example.passwordencrypto.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.passwordencrypto.repo.EncryptoRepo

class EncryptoViewModelFactory(private val encryptoRepo: EncryptoRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EncryptoViewModel(encryptoRepo) as T
    }
}