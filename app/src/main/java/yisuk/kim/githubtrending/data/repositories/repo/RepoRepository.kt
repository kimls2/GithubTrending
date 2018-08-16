package yisuk.kim.githubtrending.data.repositories.repo

import io.reactivex.Flowable
import io.reactivex.Single
import yisuk.kim.githubtrending.data.entities.GithubRepo

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
interface RepoRepository {

    fun getRepos(): Flowable<List<GithubRepo>>

    fun getRepo(id: Int): Single<GithubRepo>
}