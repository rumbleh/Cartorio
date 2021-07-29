package com.thiagoqueiroz.cartorio.ui.listacertidao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao
import com.thiagoqueiroz.cartorio.database.CertidaoDAO
import com.thiagoqueiroz.cartorio.database.MyDB
import com.thiagoqueiroz.cartorio.ui.cadastro.CadastroActivity
import com.thiagoqueiroz.cartorio.ui.listacertidao.RecyclerViewAdapter

class ListagemActivity : AppCompatActivity() {
    private lateinit var listaCertidoes : List<Certidao>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        var certidao = Certidao(0, "Jose", "Amalia", "Domingos", "10/20/2020", "F" )
        MyDB.getInstance(this).certidaoDao().inserirCertidao(certidao)

        listaCertidoes = MyDB.getInstance(this).certidaoDao().getTodasCertidoes()
        var recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(listaCertidoes)
        recyclerView.layoutManager = LinearLayoutManager(this )


        val fabNovo : FloatingActionButton = findViewById(R.id.fabNovo)

        fabNovo.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }


    }


    override fun onResume(){
        super.onResume()
        Toast.makeText(applicationContext,
            "resumi!",
            Toast.LENGTH_SHORT).show()

        listaCertidoes = MyDB.getInstance(this).certidaoDao().getTodasCertidoes()
    }
        // dados
        // recyclerview
        // adapter
}