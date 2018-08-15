package yisuk.kim.githubtrending.data.repositories.repo

import io.reactivex.Flowable
import yisuk.kim.githubtrending.data.daos.GithubRepoDao
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.data.mappers.RepoMapper
import yisuk.kim.githubtrending.network.GithubApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Singleton
class RepoRepositoryImpl @Inject constructor(
        private val githubApi: GithubApi,
        private val repoDao: GithubRepoDao,
        private val mapper: RepoMapper
) : RepoRepository {

    override fun getRepos(): Flowable<List<GithubRepo>> {
        return githubApi.getTrendingRepos()
                .map { it.items }
                .flatMapIterable { it }
                .map(mapper::map)
                .toList()
                .toFlowable()
                .doOnNext {
                    it.forEach {
                        repoDao.insert(it)
                    }
                }
    }
}