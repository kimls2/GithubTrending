package yisuk.kim.githubtrending.injection

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module
internal abstract class ViewModelBuilder {
    @Binds
    internal abstract fun bindViewModelFactory(factory: TrendingViewModelFactory): ViewModelProvider.Factory
}