package com.example.passwordencrypto.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.EncryptionPasswordBinding
import com.example.passwordencrypto.views.CipherTextEncryption
import com.example.passwordencrypto.views.RailFenceEncryption

class EncryptionFragment : Fragment(R.layout.encryption_password) {
    private lateinit var binding: EncryptionPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.encryption_password, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCipherText.setOnClickListener {
            val intent = Intent(context, CipherTextEncryption::class.java)
            startActivity(intent)
        }

        binding.btnRailFence.setOnClickListener {
            val intent = Intent(context, RailFenceEncryption::class.java)
            startActivity(intent)
        }
    }
}