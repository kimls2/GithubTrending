package yisuk.kim.githubtrending.home.repos

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import yisuk.kim.githubtrending.data.entities.GithubRepo
import yisuk.kim.githubtrending.repo

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 15-08-2018.
 */
class ReposController(
        private val callbacks: Callbacks
) : TypedEpoxyController<List<GithubRepo>>() {

    interface Callbacks {
        fun onItemClicked(item: GithubRepo)
    }

    override fun buildModels(data: List<GithubRepo>?) {
        if (data != null && data.isNotEmpty()) {
            data.forEach { item ->
                repo {
                    id(item.id)
                    repo(item)
                    starCount(item.starCount.toString())
                    clickListener(View.OnClickListener { callbacks.onItemClicked(item) })
                }
            }
        }
    }
}