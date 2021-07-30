package com.thiagoqueiroz.cartorio.ui.cadastro

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.thiagoqueiroz.cartorio.R
import com.thiagoqueiroz.cartorio.database.Certidao
import com.thiagoqueiroz.cartorio.database.MyDB


class VisualizacaoActivity : AppCompatActivity() {
    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar)

        id = intent.extras!!.getInt("id")
        val certidao : Certidao = MyDB.getInstance(this).certidaoDao().getById(id)

        title = "Visualização de Certidão"

        val edtNome : EditText = findViewById(R.id.edtNome)
        val edtMae : EditText = findViewById(R.id.edtMae)
        val edtPai : EditText = findViewById(R.id.edtPai)
        val edtData : EditText = findViewById(R.id.edtData)
        val rdgSexo : RadioGroup = findViewById(R.id.rdgSexo)

        edtNome.setText( certidao.nome )
        edtMae.setText( certidao.mae )
        edtPai.setText( certidao.pai )
        edtData.setText( certidao.data )
        val index = if (certidao.sexo == "M") 0 else 1
        val rd : RadioButton = rdgSexo.getChildAt(index) as RadioButton
        rd.isChecked = true

        val btnExcluir : Button = findViewById(R.id.btnExcluir)
        btnExcluir.setOnClickListener {

            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            builder.setTitle("Confirma a exclusão desta certidão?")
            builder.setMessage("Tem certeza?")

            builder.setPositiveButton(
                "SIM"
            ) { dialog, which -> // Do nothing but close the dialog

                MyDB.getInstance(this).certidaoDao().deleteCertidao(certidao)
                Toast.makeText(
                    applicationContext,
                    "Certidão excluída com sucesso",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
                onBackPressed()

            }

            builder.setNegativeButton(
                "NÃO"
            ) { dialog, which -> // Do nothing
                Toast.makeText(
                    applicationContext,
                    "Exclusão cancelada",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.dismiss()
            }

            val alert: AlertDialog = builder.create()
            alert.show()
        }
        val btnAtualizar : Button = findViewById(R.id.btnAtualizar)
        btnAtualizar.setOnClickListener {

            val sexo: Int = rdgSexo.checkedRadioButtonId
            val rbSexo : RadioButton = findViewById(sexo)
            val index: Int = rdgSexo.indexOfChild(rbSexo)

            val charSexo : String = if (index == 0) "M" else "F"

            val certidao = Certidao(
                id,
                edtNome.text.toString(),
                edtMae.text.toString(),
                edtPai.text.toString(),
                edtData.text.toString(),
                charSexo
            )

            MyDB.getInstance(this).certidaoDao().updateCertidao(certidao)
            Toast.makeText(applicationContext,
                "Certidão atualizada com sucesso",
                Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

    }
}