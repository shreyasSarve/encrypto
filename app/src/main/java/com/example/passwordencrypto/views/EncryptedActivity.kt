package com.example.passwordencrypto.views

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.ActivityEncryptedBinding
import com.example.passwordencrypto.db.CipherEncryptoModel
import com.example.passwordencrypto.db.DAOEncrypto
import com.example.passwordencrypto.db.EncryptoDatabase
import com.example.passwordencrypto.repo.EncryptoRepo
import com.example.passwordencrypto.viewModel.EncryptoViewModel
import com.example.passwordencrypto.viewModel.EncryptoViewModelFactory

class EncryptedActivity : AppCompatActivity() {

    private lateinit var encryptoDatabase: EncryptoDatabase
    private lateinit var daoEncrypto: DAOEncrypto
    private lateinit var encryptoViewModel: EncryptoViewModel
    private lateinit var binding: ActivityEncryptedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_encrypted)

        daoEncrypto = this.let { EncryptoDatabase.getDatabaseObject(this).getEncryptedData() }
        val encryptoRepo = EncryptoRepo(daoEncrypto)
        val encryptoViewModelFactory = EncryptoViewModelFactory(encryptoRepo)
        encryptoViewModel = ViewModelProviders.of(this, encryptoViewModelFactory).get(EncryptoViewModel::class.java)

        var intent = Intent()
        val extras = getIntent().extras
        val key = extras?.getInt("key")
        binding.tvKey.text = "Key Used $key"

        if (extras?.containsKey("encrypted") == true) {
            val encrypted = extras.getString("encrypted")
            binding.tvEncryptedData.text = encrypted
        } else if (extras?.containsKey("decrypted") == true) {
            val decrypted = extras.getString("decrypted")
            binding.tvEncryptedData.text = decrypted
        } else if (extras?.containsKey("RailFenceEncrypted") == true) {
            val railFenceEncrypted = extras.getString("RailFenceEncrypted")
            binding.tvEncryptedData.text = railFenceEncrypted
        } else if (extras?.containsKey("RailFenceDecrypted") == true) {
            val railFenceDecrypted = extras.getString("RailFenceDecrypted")
            binding.tvEncryptedData.text = railFenceDecrypted
        }

        binding.btnCopyED.setOnClickListener {
            val manager: ClipboardManager =
                this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            manager.setText(binding.tvEncryptedData.text)
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
        }

        binding.tvEncryptedData.setOnClickListener {
            val manager: ClipboardManager =
                this.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            manager.setText(binding.tvEncryptedData.text)
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show()
        }

        binding.btnHomeED.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        binding.btnSaveED.setOnClickListener {
            val encryptionTech = getIntent().extras
            val data = binding.tvEncryptedData.text.toString()
            val cipherEncryptoModel = CipherEncryptoModel(data, key!!, "encryptionTech" )
            encryptoViewModel.addEncryptData(cipherEncryptoModel)
        }
    }
}