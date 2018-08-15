package yisuk.kim.githubtrending.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import yisuk.kim.githubtrending.TrendingApp
import yisuk.kim.githubtrending.commons.AppRxSchedulers
import yisuk.kim.githubtrending.database.DatabaseModule
import yisuk.kim.githubtrending.network.NetworkModule
import java.io.File
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
@Module(includes = [
    DatabaseModule::class,
    NetworkModule::class
])
class AppModule {

    @Provides
    fun provideContext(application: TrendingApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideAppPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    @Named("cache")
    fun provideCacheDir(application: Application): File {
        return application.cacheDir
    }

    @Singleton
    @Provides
    fun provideRxSchedulers(): AppRxSchedulers = AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread()
    )
}