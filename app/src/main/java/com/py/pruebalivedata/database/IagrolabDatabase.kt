package com.py.pruebalivedata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.py.pruebalivedata.dao.ParcelaDao
import com.py.pruebalivedata.entities.Campo


@Database(
    entities = [Campo::class],
    version = 1,
    exportSchema = false
)

abstract class IagrolabDatabase : RoomDatabase() {

    abstract fun parcelaDao(): ParcelaDao

    companion object {
        /* val MIGRATION_2_3: Migration = object : Migration(2, 3) {
             override fun migrate(database: SupportSQLiteDatabase) {
                     database.execSQL("ALTER TABLE users" +
                             "ADD COLUMN address STRING");
             }
         }*/

        @Volatile
        var INSTANCE: IagrolabDatabase? = null

        fun getDatabase(context: Context): IagrolabDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IagrolabDatabase::class.java,
                    "iagrolab_database"
                    // ).fallbackToDestructiveMigration()
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}