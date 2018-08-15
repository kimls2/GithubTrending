package yisuk.kim.githubtrending.data.mappers

import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.network.GithubApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Singleton
class RepoMapper @Inject constructor() : Mapper<GithubApi.RepoItem, GithubRepo> {

    override fun map(from: GithubApi.RepoItem): GithubRepo {
        return GithubRepo(
                id = from.id,
                name = from.full_name
        )
    }
}