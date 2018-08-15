package yisuk.kim.githubtrending.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import yisuk.kim.githubtrending.home.repos.ReposBuilder

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module
internal abstract class HomeBuilder {
    @ContributesAndroidInjector(modules = [ReposBuilder::class])
    internal abstract fun homeActivity(): HomeActivity
}