package yisuk.kim.githubtrending.home.repos

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_repos.*
import yisuk.kim.githubtrending.R
import yisuk.kim.githubtrending.commons.BaseFragment
import yisuk.kim.githubtrending.commons.Status
import yisuk.kim.githubtrending.commons.observeK
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.home.HomeNavigator
import yisuk.kim.githubtrending.home.HomeViewModel

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
class ReposFragment : BaseFragment<ReposViewModel>() {

    private lateinit var homeNavigator: HomeNavigator
    private val reposController = ReposController(object : ReposController.Callbacks {
        override fun onItemClicked(item: GithubRepo) {
            homeNavigator.showDetail(item.id)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ReposViewModel::class.java)
        homeNavigator = ViewModelProviders.of(activity!!, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.refresh()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_repos.apply {
            setController(reposController)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
        repos_swipe_refresh.setOnRefreshListener(viewModel::refresh)
        viewModel.viewState.observeK(this) {
            it?.let {
                when (it.status) {
                    Status.REFRESHING -> repos_swipe_refresh.isRefreshing = true
                    Status.SUCCESS -> repos_swipe_refresh.isRefreshing = false
                    Status.ERROR -> {
                        repos_swipe_refresh.isRefreshing = false
                        Snackbar.make(rv_repos, it.message ?: "EMPTY", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
        }
        viewModel.data.observeK(this) {
            reposController.setData(it)
        }
    }
}