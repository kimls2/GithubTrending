package yisuk.kim.githubtrending.data.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import yisuk.kim.githubtrending.data.entities.GithubRepo

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Dao
abstract class GithubRepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(repo: GithubRepo)

    @Query("SELECT * from github_repo")
    abstract fun getRepos(): Flowable<List<GithubRepo>>

}