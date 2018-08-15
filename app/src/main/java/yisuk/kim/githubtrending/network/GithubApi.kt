package yisuk.kim.githubtrending.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
interface GithubApi {
    @GET("search/repositories")
    fun getTrendingRepos(
            @Query("q") query: String = "android",
            @Query("sort") sort: String = "stars"
    ): Observable<RepoResponse>

    data class RepoResponse(
            val items: List<RepoItem>
    )

    data class RepoItem(
            val id: Int,
            val full_name: String,
            val description: String,
            val stargazers_count: Int
    )
}