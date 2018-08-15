package yisuk.kim.githubtrending.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import yisuk.kim.githubtrending.database.daos.GithubRepoDao
import yisuk.kim.githubtrending.database.entities.GithubRepo

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Database(
        entities = [GithubRepo::class],
        version = 1
)
abstract class TrendingDatabase : RoomDatabase() {
    abstract fun githubRepoDao(): GithubRepoDao
}