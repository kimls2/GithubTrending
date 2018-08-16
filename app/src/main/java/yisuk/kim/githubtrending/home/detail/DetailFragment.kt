package yisuk.kim.githubtrending.home.detail

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import yisuk.kim.githubtrending.commons.BaseFragment
import yisuk.kim.githubtrending.commons.observeK
import yisuk.kim.githubtrending.databinding.FragmentDetailBinding

/**
 * @author <a href="yisuk@mobilabsolutions.com">Yisuk Kim</a> on 16-08-2018.
 */
class DetailFragment : BaseFragment<DetailViewModel>() {

    companion object {
        private const val KEY_REPO_ID = "repo_id"

        fun create(id: Int): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_REPO_ID, id)
                }
            }
        }
    }

    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        arguments?.let {
            viewModel.repoId = it.getInt(KEY_REPO_ID)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.detailToolbar.setNavigationOnClickListener { activity?.onBackPressed() }

        viewModel.data.observeK(this) {
            it?.let(binding::setRepo)
        }
    }
}