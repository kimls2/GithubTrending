package yisuk.kim.githubtrending.data.mappers

import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.network.dto.RepoItem
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Singleton
class RepoMapper @Inject constructor() : Mapper<RepoItem, GithubRepo> {

    override fun map(from: RepoItem): GithubRepo {
        return GithubRepo(
                id = from.id,
                name = from.full_name,
                description = from.description,
                starCount = from.stargazers_count,
                login = from.owner.login,
                avatarUrl = from.owner.avatar_url,
                htmlUrl = from.html_url
        )
    }
}