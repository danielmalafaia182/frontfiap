package br.com.fiap.locamail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "email_login")
    var emailLogin: String = "",
    var password: String = "",
    @ColumnInfo(name = "dt_nascimento")
    var dtNascimento: String = "",
    var gender: String = "",
    @ColumnInfo(name = "first_name")
    var firstName: String = "",
    @ColumnInfo(name = "last_name")
    var lastName:String = "",
    ) {
}