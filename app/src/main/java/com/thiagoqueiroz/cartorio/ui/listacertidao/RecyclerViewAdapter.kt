package com.thiagoqueiroz.cartorio.ui.listacertidao

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao

class RecyclerViewAdapter (private val listaCertidoes : List<Certidao>) : RecyclerView.Adapter<RecyclerViewAdapter.CertidaoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CertidaoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_certidao,
            parent,
            false
        )
        return CertidaoViewHolder(view)
    }

    override fun getItemCount(): Int = listaCertidoes.count()

    override fun onBindViewHolder(usuarioViewHolder: CertidaoViewHolder, position: Int) {
        usuarioViewHolder.bind(
            listaCertidoes[position]
        )
    }

    inner class CertidaoViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvNome : TextView = view.findViewById(R.id.tvNome)

        fun bind(certidao: Certidao){
            tvNome.text = certidao.nome
        }
    }

}