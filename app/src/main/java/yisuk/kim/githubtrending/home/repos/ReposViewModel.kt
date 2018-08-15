package yisuk.kim.githubtrending.home.repos

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.plusAssign
import yisuk.kim.githubtrending.commons.AppRxSchedulers
import yisuk.kim.githubtrending.commons.BaseViewModel
import yisuk.kim.githubtrending.commons.State
import yisuk.kim.githubtrending.commons.Status
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.data.repositories.repo.RepoRepository
import javax.inject.Inject

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
class ReposViewModel @Inject constructor(
        private val repoRepository: RepoRepository,
        private val schedulers: AppRxSchedulers
) : BaseViewModel() {

    private val _repos = MutableLiveData<List<GithubRepo>>()
    val data: LiveData<List<GithubRepo>>
        get() = _repos

    init {
        refresh()
    }

    fun refresh() {
        disposables += repoRepository.getRepos()
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.main)
                .doOnSubscribe { sendMessage(State(Status.REFRESHING)) }
                .doOnNext { sendMessage(State(Status.SUCCESS)) }
                .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(repos: List<GithubRepo>) {
        _repos.value = repos
    }
}