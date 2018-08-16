package yisuk.kim.githubtrending.home.repos

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import io.reactivex.Flowable
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import yisuk.kim.githubtrending.commons.State
import yisuk.kim.githubtrending.commons.Status
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.data.repositories.repo.RepoRepository
import yisuk.kim.githubtrending.factory.GitHubTrendingFactory

/**
 * @author [Yisuk Kim](yisuk@mobilabsolutions.com) on 16-08-2018.
 */
class ReposViewModelTest {

    @Suppress("unused")
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repoRepository: RepoRepository
    @Mock
    private lateinit var testStateObserver: Observer<State>
    @Mock
    private lateinit var testDataObserver: Observer<List<GithubRepo>>

    private lateinit var reposViewModel: ReposViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        reposViewModel = ReposViewModel(repoRepository)
    }

    @Test
    fun refresh_shouldSendRefreshingStatus() {
        given(repoRepository.getRepos()).willReturn(Flowable.just(mutableListOf()))
        reposViewModel.viewState.observeForever(testStateObserver)
        reposViewModel.refresh()

        val inOrder = Mockito.inOrder(testStateObserver)
        inOrder.verify(testStateObserver).onChanged(State(Status.REFRESHING))
        inOrder.verify(testStateObserver).onChanged(State(Status.SUCCESS))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun viewState_shouldSendErrorMessage_ifCallFails() {
        given(repoRepository.getRepos()).willReturn(Flowable.error(Throwable()))
        reposViewModel.viewState.observeForever(testStateObserver)
        reposViewModel.refresh()

        val inOrder = Mockito.inOrder(testStateObserver)
        inOrder.verify(testStateObserver).onChanged(State(Status.REFRESHING))
        inOrder.verify(testStateObserver).onChanged(State(Status.ERROR))
        inOrder.verifyNoMoreInteractions()
    }

    @Test
    fun getUsers_success() {
        val mockData = GitHubTrendingFactory.makeGitHubRepoList(10)

        given(repoRepository.getRepos()).willReturn(Flowable.just(mockData))
        reposViewModel.data.observeForever(testDataObserver)
        reposViewModel.refresh()

        assertThat(reposViewModel.data.value, CoreMatchers.`is`(mockData))
    }

}