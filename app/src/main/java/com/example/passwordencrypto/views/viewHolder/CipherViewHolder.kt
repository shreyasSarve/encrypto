package com.example.passwordencrypto.views.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordencrypto.R
import com.example.passwordencrypto.db.CipherEncryptoModel
import com.example.passwordencrypto.views.adapter.ItemClickListener

class CipherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvData : TextView = itemView.findViewById(R.id.tvCipherData)
    val tvKey : TextView = itemView.findViewById(R.id.tvCipherKey)
    val crdCipherItem : TextView = itemView.findViewById(R.id.crdCipherItem)


    fun setData(cipherEncryptoModel: CipherEncryptoModel, clickListener: ItemClickListener){
        tvData.text = cipherEncryptoModel.data
        tvKey.text = cipherEncryptoModel.key.toString()

        crdCipherItem.setOnClickListener {
            clickListener.onCipherCardClick(cipherEncryptoModel)
        }
    }
}