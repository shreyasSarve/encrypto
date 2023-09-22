package com.example.passwordencrypto.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.ActivityDetailBinding
import com.example.passwordencrypto.db.CipherEncryptoModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        var intent = intent
        val extras = getIntent().extras

        val cipherModel = extras?.getSerializable("detail") as CipherEncryptoModel

        binding.tvEncText.text = cipherModel.data

        binding.tvEncKey.text = "Key ${cipherModel.key}"
    }
}