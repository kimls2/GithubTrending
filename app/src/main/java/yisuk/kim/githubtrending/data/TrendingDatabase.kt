package yisuk.kim.githubtrending.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import yisuk.kim.githubtrending.data.daos.GithubRepoDao
import yisuk.kim.githubtrending.data.entities.GithubRepo

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