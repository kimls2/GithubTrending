package yisuk.kim.githubtrending.home.repos

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import yisuk.kim.githubtrending.injection.ViewModelKey

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module
internal abstract class ReposBuilder {
    @ContributesAndroidInjector
    internal abstract fun reposFragment(): ReposFragment

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    abstract fun bindReposViewModel(viewModel: ReposViewModel): ViewModel
}