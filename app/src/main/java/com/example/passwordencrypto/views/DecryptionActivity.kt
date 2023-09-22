package com.example.passwordencrypto.views

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.ActivityDecryptionBinding
import org.jetbrains.anko.toast
import java.lang.StringBuilder


class DecryptionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDecryptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_decryption)
        binding.apply {

            radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val radioButton: Int = radioGroup.checkedRadioButtonId

                if (checkboxCipher.id == radioButton) {
                   toast("Cipher encryption selected")
                }
                if (checkboxRailFence.id == radioButton) {
                    val data = "No need to select key"
                    etDecryptKey.setText(data)
                    etDecryptKey.isClickable = false
                    toast("Rail Fence encryption selected")
                }
            }

            btnDecryptData.setOnClickListener {
                if (checkboxCipher.isChecked) {
                    val encryptedData = etDecryptData.text.toString()
                    val key = etDecryptKey.text.toString().toInt()
                    val decryptedData: String = decryptData(encryptedData, key)
                   performIntentAction("decrypted", decryptedData)
                } else if (checkboxRailFence.isChecked) {
                    val encryptedData = etDecryptData.text.toString()
                    val decryptedData = decryptRailFenceData(encryptedData)
                    performIntentAction("RailFenceDecrypted", decryptedData)
                }
            }
        }
    }

    private fun decryptRailFenceData(encryptedData: String): String {
        var str = ""
        val k: Int
        var j: Int

        if (encryptedData.length % 2 == 0) {
            j = encryptedData.length / 2
        } else {
            j = encryptedData.length / 2 + 1
        }
        k = j
        var i = 0
        while (i < k) {
            str += encryptedData[i]
            str += encryptedData[j]
            i++
            j++
        }
        return str
    }

    private fun decryptData(str: String, key: Int): String {
//        var encryptedStr: String = ""
        var encryptedStr : StringBuilder = StringBuilder()
        for (i in str.indices) {
            if (str[i] in 'a'..'z') {
//                encryptedStr += ((str[i].hashCode() - key - 97) % 26 + 97).toChar()
                encryptedStr.append((str[i].hashCode() - key -97)  + 97)
            } else if (str[i] in 'A'..'Z') {
//                val upper = ((str[i].hashCode() - key - 65) % 26 + 65)
                val uppercase = ((str[i].hashCode() - key -65) + 65)
                encryptedStr.append(uppercase)
            } else if (str[i] in '0'..'9') {
//                val number = ((str[i].hashCode() - key - 48) % 10 + 48).toChar()
                encryptedStr.append((str[i].hashCode() - key -48) + 48)
            } else {
                encryptedStr.append(str[i])
            }
        }
        return encryptedStr.toString()
    }

    private fun performIntentAction(key: String, data: String){
        val intent = Intent(this, EncryptedActivity::class.java)
        intent.putExtra(key, data)
        startActivity(intent)
    }
}