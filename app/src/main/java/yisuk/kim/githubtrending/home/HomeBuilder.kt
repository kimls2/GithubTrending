package yisuk.kim.githubtrending.home

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import yisuk.kim.githubtrending.home.detail.DetailBuilder
import yisuk.kim.githubtrending.home.repos.ReposBuilder
import yisuk.kim.githubtrending.injection.ViewModelKey

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module
internal abstract class HomeBuilder {
    @ContributesAndroidInjector(modules = [ReposBuilder::class, DetailBuilder::class])
    internal abstract fun homeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}