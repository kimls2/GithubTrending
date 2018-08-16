package yisuk.kim.githubtrending.network.dto

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
data class Owner(
        val login: String,
        val id: Int,
        val avatar_url: String = ""
)