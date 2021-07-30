package com.thiagoqueiroz.cartorio.ui.listacertidao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao
import com.thiagoqueiroz.cartorio.database.MyDB
import com.thiagoqueiroz.cartorio.ui.cadastro.CadastroActivity
import com.thiagoqueiroz.cartorio.ui.cadastro.VisualizacaoActivity

interface CellClickListener {
    fun onCellClickListener(id: Int)
}

class ListagemActivity : AppCompatActivity(), CellClickListener {
    private lateinit var listaCertidoes : List<Certidao>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)
        title = "Cartório Digital"
        val fabNovo : FloatingActionButton = findViewById(R.id.fabNovo)

        fabNovo.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume(){
        super.onResume()
        atualizaListView()
    }

    fun atualizaListView(){
        listaCertidoes = MyDB.getInstance(this).certidaoDao().getTodasCertidoes()
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = RecyclerViewAdapter(this, listaCertidoes, this)
        recyclerView.layoutManager = LinearLayoutManager(this )
    }

    override fun onCellClickListener(id: Int) {
        val intent = Intent(this, VisualizacaoActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}
