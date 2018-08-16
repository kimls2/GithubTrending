package yisuk.kim.githubtrending.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import yisuk.kim.githubtrending.commons.SingleLiveEvent
import javax.inject.Inject

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
class HomeViewModel @Inject constructor() : ViewModel(), HomeNavigator {

    val showDetailCall: LiveData<Int>
        get() = _showDetailCall
    private val _showDetailCall = SingleLiveEvent<Int>()

    override fun showDetail(repoId: Int) {
        _showDetailCall.value = repoId
    }

}