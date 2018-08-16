package yisuk.kim.githubtrending.home.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.rxkotlin.plusAssign
import yisuk.kim.githubtrending.commons.AppRxSchedulers
import yisuk.kim.githubtrending.commons.BaseViewModel
import yisuk.kim.githubtrending.data.daos.GithubRepoDao
import yisuk.kim.githubtrending.data.entities.GithubRepo
import javax.inject.Inject

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
class DetailViewModel @Inject constructor(
        private val githubRepoDao: GithubRepoDao,
        private val schedulers: AppRxSchedulers
) : BaseViewModel() {

    var repoId: Int = -1
        set(value) {
            field = value
            getDetail(value)
        }

    val data: LiveData<GithubRepo>
        get() = _repo
    private val _repo = MutableLiveData<GithubRepo>()

    private fun getDetail(id: Int) {
        disposables += githubRepoDao.getRepoWithId(id)
                .subscribeOn(schedulers.io)
                .observeOn(schedulers.main)
                .subscribe(this::onSuccess, this::onError)
    }

    private fun onSuccess(repo: GithubRepo) {
        _repo.value = repo
    }
}