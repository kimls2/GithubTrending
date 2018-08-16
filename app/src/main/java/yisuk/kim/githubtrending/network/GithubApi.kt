package yisuk.kim.githubtrending.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import yisuk.kim.githubtrending.network.dto.RepoItem

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
interface GithubApi {

    // This call is not actually TRENDING repositories. Because the search is queried by "android".
    @GET("search/repositories")
    fun getTrendingRepos(
            @Query("q") query: String = "android",
            @Query("sort") sort: String = "stars"
    ): Observable<RepoResponse>

    data class RepoResponse(
            val items: List<RepoItem>
    )
}