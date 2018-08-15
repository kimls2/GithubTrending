package yisuk.kim.githubtrending.injection

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import yisuk.kim.githubtrending.TrendingApp
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<TrendingApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TrendingApp>()
}