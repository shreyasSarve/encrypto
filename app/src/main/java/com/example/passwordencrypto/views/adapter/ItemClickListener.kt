package com.example.passwordencrypto.views.adapter

import com.example.passwordencrypto.db.CipherEncryptoModel

interface ItemClickListener {

    fun onCipherCardClick(cipherEncryptoModel: CipherEncryptoModel)
}