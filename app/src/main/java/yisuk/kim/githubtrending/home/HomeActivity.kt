package yisuk.kim.githubtrending.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import yisuk.kim.githubtrending.R
import yisuk.kim.githubtrending.commons.observeK
import yisuk.kim.githubtrending.home.detail.DetailFragment
import yisuk.kim.githubtrending.home.repos.ReposFragment
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.showDetailCall.observeK(this, this::showDetail)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(home_content.id, ReposFragment())
                    .commit()
        }
    }

    private fun showDetail(id: Int?) {
        id?.let {
            supportFragmentManager
                    .beginTransaction()
                    .replace(home_content.id, DetailFragment())
                    .addToBackStack("detail fragment")
                    .commit()
        }
    }
}
