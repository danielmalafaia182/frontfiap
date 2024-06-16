package br.com.fiap.locamail.database.dao

import androidx.room.Dao
import androidx.room.Insert
import br.com.fiap.locamail.model.User

@Dao
interface UserDao {

    @Insert
    fun salvar(user: User): Long

//    fun atualizar()
//
//    fun excluir()
//
//    fun buscarContatoPeloId()
//
//    fun listarContatos()
}