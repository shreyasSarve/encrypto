package com.example.passwordencrypto.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.passwordencrypto.fragments.DecryptionFragment
import com.example.passwordencrypto.fragments.EncryptionFragment
import com.example.passwordencrypto.fragments.PasswordFragment
import com.example.passwordencrypto.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_enhanced_encryption_24))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_baseline_password_24))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_baseline_key_24))

        bottomNavigation.setOnShowListener { item ->
            var fragment: Fragment? = null
            when (item.id) {
                1 -> fragment = EncryptionFragment()
                2 -> fragment = PasswordFragment()
                3 -> fragment = DecryptionFragment()
            }
            loadFragment(fragment)
        }

        bottomNavigation.show(2, true)

        bottomNavigation.setOnClickMenuListener {
        }

        bottomNavigation.setOnReselectListener {
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment!!).commit()
    }
}