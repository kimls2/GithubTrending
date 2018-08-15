package yisuk.kim.githubtrending.commons

import io.reactivex.Scheduler

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
data class AppRxSchedulers(
        val io: Scheduler,
        val computation: Scheduler,
        val main: Scheduler
)