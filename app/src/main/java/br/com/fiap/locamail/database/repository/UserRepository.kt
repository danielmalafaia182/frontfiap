package br.com.fiap.locamail.database.repository

import android.content.Context
import br.com.fiap.locamail.database.dao.UserDb
import br.com.fiap.locamail.model.User

class UserRepository(context: Context) {

    var db = UserDb.getDataBase(context).userDao()

    fun salvar(user: User): Long {
        return db.salvar(user = user)
    }
}