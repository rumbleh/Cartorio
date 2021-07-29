package com.thiagoqueiroz.cartorio.ui.listacertidao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao
import com.thiagoqueiroz.cartorio.database.CertidaoDAO
import com.thiagoqueiroz.cartorio.database.MyDB
import com.thiagoqueiroz.cartorio.ui.listacertidao.RecyclerViewAdapter

class ListagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        var certidao = Certidao(0, "Jose", "Amalia", "Domingos", "10/20/2020", 1,2,3 )
        MyDB.getInstance(this).certidaoDao().inserirCertidao(certidao)

        val listaCertidoes = MyDB.getInstance(this).certidaoDao().getTodasCertidoes();
        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(listaCertidoes)
        recyclerView.layoutManager = LinearLayoutManager(this )

        // dados
        // recyclerview
        // adapter

    }
}