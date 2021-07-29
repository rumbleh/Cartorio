package com.thiagoqueiroz.cartorio.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Certidao(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "nome") val nome : String,
    @ColumnInfo(name = "mae") val mae : String,
    @ColumnInfo(name = "pai") val pai : String,
    @ColumnInfo(name = "data") val data : String,
    @ColumnInfo(name = "sexo") val sexo : String
)