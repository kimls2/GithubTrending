package yisuk.kim.githubtrending.commons

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
abstract class BaseViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    private val messages: BehaviorSubject<State> = BehaviorSubject.create()
    val viewState: LiveData<State> = LiveDataReactiveStreams.fromPublisher(
            Flowable.fromPublisher(messages.toFlowable(BackpressureStrategy.LATEST)))

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    protected fun onError(t: Throwable) {
        Timber.e(t)
        sendMessage(State(Status.ERROR, t.localizedMessage))
    }

    protected fun sendMessage(state: State) {
        messages.onNext(state)
    }
}