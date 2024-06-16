package br.com.fiap.locamail.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.locamail.model.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class UserDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private lateinit var instance: UserDb

        fun getDataBase(context: Context): UserDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        UserDb::class.java,
                        name = "user_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}
