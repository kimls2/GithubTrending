package yisuk.kim.githubtrending.database.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import yisuk.kim.githubtrending.database.entities.GithubRepo

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Dao
abstract class GithubRepoDao {
    @Insert
    abstract fun insert(repo: GithubRepo)

}