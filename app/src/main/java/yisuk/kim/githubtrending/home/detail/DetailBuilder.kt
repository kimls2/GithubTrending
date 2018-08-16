package yisuk.kim.githubtrending.home.detail

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import yisuk.kim.githubtrending.injection.ViewModelKey

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
@Module
internal abstract class DetailBuilder {
    @ContributesAndroidInjector
    internal abstract fun detailFragment(): DetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}