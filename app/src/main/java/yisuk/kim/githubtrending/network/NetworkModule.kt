package yisuk.kim.githubtrending.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yisuk.kim.githubtrending.BuildConfig
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BASE_URL = ""
        private const val DISK_CACHE_SIZE = (10 * 1024 * 1024).toLong()
        private const val READ_TIME_OUT = 15.toLong()
        private const val CONNECT_TIME_OUT = 30.toLong()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@Named("cache") cacheDir: File): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                addNetworkInterceptor(StethoInterceptor())
            }
            readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            cache(Cache(File(cacheDir, "app_cache"), DISK_CACHE_SIZE))
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()

    }
}