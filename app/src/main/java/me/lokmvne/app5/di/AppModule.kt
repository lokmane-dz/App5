package me.lokmvne.app5.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.lokmvne.app5.data.ItemDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesDao(db: ItemDB) = db.itemDao()

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): ItemDB {
        return Room.databaseBuilder(
            context,
            ItemDB::class.java,
            "item_database"
        ).build()
    }

}