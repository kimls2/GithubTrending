package yisuk.kim.githubtrending.commons

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
data class State(
        val status: Status,
        val message: String? = null
)

enum class Status {
    ERROR,
    SUCCESS,
    REFRESHING
}
