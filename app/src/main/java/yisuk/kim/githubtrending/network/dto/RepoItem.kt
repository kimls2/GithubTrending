package yisuk.kim.githubtrending.network.dto

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
data class RepoItem(
        val id: Int,
        val full_name: String,
        val description: String,
        val stargazers_count: Int,
        val html_url: String,
        val owner: Owner
)