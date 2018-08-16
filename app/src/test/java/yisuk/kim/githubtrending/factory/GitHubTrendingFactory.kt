package yisuk.kim.githubtrending.factory

import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.factory.DataFactory.Factory.randomInt
import yisuk.kim.githubtrending.factory.DataFactory.Factory.randomUuid

/**
 * @author <a href="kimls125@gmail.com">Yisuk Kim</a> on 03-06-2018.
 */
class GitHubTrendingFactory {

    companion object Factory {

        fun makeGitHubRepoList(count: Int): List<GithubRepo> {
            val gitHubUsers = mutableListOf<GithubRepo>()
            repeat(count) {
                gitHubUsers.add(makeGitHubRepo(randomInt()))
            }
            return gitHubUsers
        }

        fun makeGitHubRepo(id: Int): GithubRepo {
            return GithubRepo(id = id,
                    name = randomUuid(),
                    description = randomUuid(),
                    htmlUrl = randomUuid(),
                    starCount = randomInt(),
                    login = randomUuid(),
                    avatarUrl = null
            )
        }
    }
}