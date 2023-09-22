package com.example.passwordencrypto.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.FragmentDecryptionBinding
import com.example.passwordencrypto.views.DecryptionActivity

class DecryptionFragment : Fragment(R.layout.fragment_decryption) {
    private lateinit var binding: FragmentDecryptionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_decryption, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDecryption.setOnClickListener {
            val intent = Intent(context, DecryptionActivity::class.java)
            startActivity(intent)
        }
    }
}