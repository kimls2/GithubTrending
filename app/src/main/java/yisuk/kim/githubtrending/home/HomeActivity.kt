package yisuk.kim.githubtrending.home

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import yisuk.kim.githubtrending.R
import yisuk.kim.githubtrending.home.repos.ReposFragment
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(home_content.id, ReposFragment())
                    .commit()
        }
    }
}
