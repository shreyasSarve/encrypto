package com.example.passwordencrypto.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.ActivityRailFenceBinding

class RailFenceEncryption : AppCompatActivity() {
    private lateinit var binding: ActivityRailFenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rail_fence)

        binding.btnRailFenceData.setOnClickListener {
            val str: String = binding.etRailFenceData.text.toString()
            val data = encryptData(str)

            val intent = Intent(this, EncryptedActivity::class.java)
            intent.putExtra("RailFenceEncrypted", data)
            startActivity(intent)
        }
    }

    private fun encryptData(str: String): String {
        val len: Int = str.length
        var start = ""
        var end = ""
        var temp = ""
        for (i in 0 until len) {
            if (str[i] != ' ') {
                temp += str[i]
            }
        }
        for (i in temp.indices) {
            if (i % 2 == 0) {
                start += temp[i]
            } else {
                end += temp[i]
            }
        }
        return start + end
    }
}