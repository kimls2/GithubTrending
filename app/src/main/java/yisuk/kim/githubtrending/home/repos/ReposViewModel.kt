package yisuk.kim.githubtrending.home.repos

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.plusAssign
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
        private val repoRepository: RepoRepository
) : BaseViewModel() {

    private val _repos = MutableLiveData<List<GithubRepo>>()
    val data: LiveData<List<GithubRepo>>
        get() = _repos

    fun refresh() {
        disposables += repoRepository.getRepos()
                .doOnSubscribe { sendMessage(State(Status.REFRESHING)) }
                .doOnNext { sendMessage(State(Status.SUCCESS)) }
                .subscribe(_repos::setValue, this::onError)
    }
}