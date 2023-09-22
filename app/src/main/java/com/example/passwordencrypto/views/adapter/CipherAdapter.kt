package com.example.passwordencrypto.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordencrypto.R
import com.example.passwordencrypto.db.CipherEncryptoModel
import com.example.passwordencrypto.views.viewHolder.CipherViewHolder

class CipherAdapter(
    val context: Context,
    val dataList: MutableList<CipherEncryptoModel>,
    val clickListener: ItemClickListener
) : RecyclerView.Adapter<CipherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CipherViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.cipher_item_layout, parent, false)
        return CipherViewHolder(view)
    }

    override fun onBindViewHolder(holder: CipherViewHolder, position: Int) {
        val cipherEncryptoModel = dataList[position]
        holder.setData(cipherEncryptoModel, clickListener)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}