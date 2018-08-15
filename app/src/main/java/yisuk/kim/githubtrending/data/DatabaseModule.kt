package yisuk.kim.githubtrending.data

import android.arch.persistence.room.Room
import android.content.Context
import android.os.Debug
import dagger.Module
import dagger.Provides
import yisuk.kim.githubtrending.data.daos.GithubRepoDao
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module
class DatabaseModule {

    companion object {
        private const val DATABASE_NAME = "trending.db"
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TrendingDatabase {
        val builder = Room.databaseBuilder(context, TrendingDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
        if (Debug.isDebuggerConnected()) {
            builder.allowMainThreadQueries()
        }
        return builder.build()
    }

    @Provides
    fun provideRepoDao(database: TrendingDatabase): GithubRepoDao {
        return database.githubRepoDao()
    }
}