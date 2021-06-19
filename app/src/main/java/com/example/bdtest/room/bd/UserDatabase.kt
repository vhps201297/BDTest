package com.example.bdtest.room.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bdtest.room.bd.dao.UserDao
import com.example.bdtest.room.bd.entity.Task
import com.example.bdtest.room.bd.entity.User

@Database(entities = [User::class, Task::class], version = 1)
abstract class UserDatabase: RoomDatabase(){
    abstract fun userDatabase(): UserDao
    companion object{
        private const val NAME_DATABASE = "user_tasks_bd"
        private val INSTANCE: UserDatabase? = null
        fun getInstance(ctx: Context): UserDatabase?{
            if (INSTANCE != null){
                return Room.databaseBuilder(ctx, UserDatabase::class.java, NAME_DATABASE)
                    .allowMainThreadQueries()
                    .build()
            } else{
                return INSTANCE
            }
        }
    }

}