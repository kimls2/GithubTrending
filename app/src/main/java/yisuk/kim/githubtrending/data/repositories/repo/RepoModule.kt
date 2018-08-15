package yisuk.kim.githubtrending.data.repositories.repo

import dagger.Binds
import dagger.Module

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */

@Module
abstract class RepoModule {

    @Binds
    abstract fun bind(source: RepoRepositoryImpl): RepoRepository

}