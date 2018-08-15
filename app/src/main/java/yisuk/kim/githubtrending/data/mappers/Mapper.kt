package yisuk.kim.githubtrending.data.mappers

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
interface Mapper<F, T> {
    fun map(from: F): T
}