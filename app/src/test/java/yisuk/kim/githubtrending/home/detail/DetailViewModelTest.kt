package yisuk.kim.githubtrending.home.detail

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import io.reactivex.Single
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.data.repositories.repo.RepoRepository
import yisuk.kim.githubtrending.factory.GitHubTrendingFactory

/**
 * @author [Yisuk Kim](yisuk@mobilabsolutions.com) on 16-08-2018.
 */
class DetailViewModelTest {

    @Suppress("unused")
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repoRepository: RepoRepository
    @Mock
    private lateinit var testDataObserver: Observer<GithubRepo>

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailViewModel(repoRepository)
    }

    @Test
    fun getDetail_success() {
        val repoId = 100
        val mockRepo = GitHubTrendingFactory.makeGitHubRepo(repoId)
        given(repoRepository.getRepo(repoId)).willReturn(Single.just(mockRepo))

        viewModel.repoId = repoId
        viewModel.data.observeForever(testDataObserver)

        assertThat(viewModel.data.value, `is`(mockRepo))
    }
}