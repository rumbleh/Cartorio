package com.thiagoqueiroz.cartorio.ui.cadastro

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao
import com.thiagoqueiroz.cartorio.database.MyDB

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        title = "Cadastro de Certidão"

        val edtNome : EditText = findViewById(R.id.edtNome)
        val edtMae : EditText = findViewById(R.id.edtMae)
        val edtPai : EditText = findViewById(R.id.edtPai)
        val edtData : EditText = findViewById(R.id.edtData)
        val rdgSexo : RadioGroup = findViewById(R.id.rdgSexo)

        val btnSalvar : Button = findViewById(R.id.btnSalvar)
        btnSalvar.setOnClickListener {

            val sexo: Int = rdgSexo.checkedRadioButtonId
            val rbSexo : RadioButton = findViewById(sexo)
            val index: Int = rdgSexo.indexOfChild(rbSexo)
            val charSexo : String

            if (index == 0) {
                charSexo = "M"
            } else {
                charSexo = "F"
            }

            val certidao = Certidao(
                0,
                edtNome.text.toString(),
                edtMae.text.toString(),
                edtPai.text.toString(),
                edtData.text.toString(),
                charSexo
            )

            MyDB.getInstance(this).certidaoDao().inserirCertidao(certidao)
            Toast.makeText(applicationContext,
                "Certidão incluída com sucesso",
                Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

    }
}