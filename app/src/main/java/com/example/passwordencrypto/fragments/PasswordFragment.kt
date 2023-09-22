package com.example.passwordencrypto.fragments

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.passwordencrypto.R
import com.example.passwordencrypto.databinding.FragmentPasswordBinding
import java.util.*


class PasswordFragment : Fragment(R.layout.fragment_password) {
    private lateinit var binding: FragmentPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_password, container, false)
        return binding.root
    }

    private var progress: Int = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seekBar = view.findViewById(R.id.seekbar) as SeekBar

        val menuBar: TextView = view.findViewById(R.id.tvMenu)

        menuBar.setOnClickListener {
            val popupMenu = PopupMenu(context, menuBar)
            popupMenu.inflate(R.menu.top_menu_bar)

            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.copy -> {
                        val manager: ClipboardManager =
                            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        manager.setText(binding.tvGeneratedPasswd.text)
                        Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
                    }
                    R.id.save -> {
                        Toast.makeText(context, "Data Saved Successfully", Toast.LENGTH_SHORT)
                            .show()
                    }
                    R.id.more -> {
                        Toast.makeText(context, "will update soon", Toast.LENGTH_SHORT).show()
                    }
                }
                false
            }
            popupMenu.show()
        }

        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progresValue: Int, fromUser: Boolean) {
                progress = progresValue
                binding.tvSeekMax.text = progress.toString()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        binding.tvGeneratedPasswd.setOnClickListener {
            val manager: ClipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            manager.setText(binding.tvGeneratedPasswd.text)
            Toast.makeText(context, "Copied", Toast.LENGTH_SHORT).show()
        }

        binding.btnGenerate.setOnClickListener {
            binding.tvGeneratedPasswd.text = generateRandomPassword()
        }
    }

    private fun generateRandomPassword(): String {
        val upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val lowerCaseChars = "abcdefghijklmnopqrstuvwxyz"
        val numberChars = "0123456789"
        val specialChars = "!@#$%^&*()_-+=<>?/{}~|"
        var allowedChars = ""
        val rn = Random()
        val sb = StringBuilder(progress)

        if (binding.checkboxUppercase.isChecked) {
            allowedChars += upperCaseChars
            sb.append(upperCaseChars[rn.nextInt(upperCaseChars.length - 1)])
        }
        if (binding.checkboxLowercase.isChecked) {
            allowedChars += lowerCaseChars
            sb.append(lowerCaseChars[rn.nextInt(lowerCaseChars.length - 1)])
        }
        if (binding.checkboxNumbers.isChecked) {
            allowedChars += numberChars
            sb.append(numberChars[rn.nextInt(numberChars.length - 1)])
        }
        if (binding.checkboxSymbols.isChecked) {
            allowedChars += specialChars
            sb.append(specialChars[rn.nextInt(specialChars.length - 1)])
        }

        if (binding.checkboxSavePasswd.isChecked) {
            Toast.makeText(context, "Password saved successfully", Toast.LENGTH_SHORT).show()
        }

        for (i in sb.length until progress) {
            sb.append(allowedChars[rn.nextInt(allowedChars.length)])
        }
        return sb.toString()
    }
}