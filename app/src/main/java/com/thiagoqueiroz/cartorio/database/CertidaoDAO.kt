package com.thiagoqueiroz.cartorio.database
import androidx.room.*

@Dao
interface CertidaoDAO {

    @Query("select * from certidao")
    fun getTodasCertidoes() : List<Certidao>

    @Insert
    fun inserirCertidao(certidao: Certidao)

    @Update
    fun updateCertidao(certidao: Certidao)

    @Delete
    fun deleteCertidao(certidao: Certidao)
}