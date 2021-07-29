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
    @ColumnInfo(name = "nascimento") val nascimento : String,
    @ColumnInfo(name = "livro") val livro : Int,
    @ColumnInfo(name = "folha") val folha : Int,
    @ColumnInfo(name = "termo") val termo : Int
)