package mahmoud.alim.marsrover.presentation.ui.screens.photos

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import mahmoud.alim.marsrover.R
import mahmoud.alim.marsrover.core.network.ConnectivityObserver
import mahmoud.alim.marsrover.databinding.FragmentPhotosBinding
import mahmoud.alim.marsrover.domain.model.RoverPhoto
import mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter.RoverPhotoLoadStateAdapter
import mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter.RoverPhotosAdapter
import javax.inject.Inject

@AndroidEntryPoint
class PhotosFragment : Fragment(), RoverPhotosAdapter.OnItemClickListener {

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PhotosViewModel by viewModels()

    @Inject
    lateinit var connectivityObserver: ConnectivityObserver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            connectivityObserver.observe()
                .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when (it) {
                        ConnectivityObserver.NetworkStatus.Available -> announceNetworkStatus(R.string.network_retrived)
                        ConnectivityObserver.NetworkStatus.Idle -> Unit
                        ConnectivityObserver.NetworkStatus.Lost -> announceNetworkStatus(R.string.network_lost)
                        ConnectivityObserver.NetworkStatus.NotAvailable -> announceNetworkStatus(R.string.network_not_available)
                    }
                }
        }

        val photoAdapter = RoverPhotosAdapter(this)
        setupRecycler(photoAdapter)

        lifecycleScope.launch {
            viewModel.photos.distinctUntilChanged().collectLatest {
                photoAdapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }


    override fun onItemClick(photo: RoverPhoto) {
        val photoDetails = viewModel.getPhotoDetails(photo)
        val action = PhotosFragmentDirections.actionPhotosFragmentToDetailsFragment(photoDetails)
        findNavController().navigate(action)
    }

    private fun setupRecycler(adapter: RoverPhotosAdapter) {
        setupLoadState(adapter)
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.itemAnimator = null
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = RoverPhotoLoadStateAdapter { adapter.retry() },
                footer = RoverPhotoLoadStateAdapter { adapter.retry() }
            )
            buttonRetry.setOnClickListener {
                adapter.retry()
            }
        }
    }


    private fun setupLoadState(adapter: RoverPhotosAdapter) {
        adapter.addLoadStateListener {
            binding.apply {
                progressBar.isVisible = it.source.refresh is LoadState.Loading
                recyclerView.isVisible = it.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = it.source.refresh is LoadState.Error
                tvError.isVisible = it.source.refresh is LoadState.Error

                if (it.source.refresh is LoadState.NotLoading &&
                    it.append.endOfPaginationReached &&
                    adapter.itemCount == 0
                ) {
                    recyclerView.isVisible = false
                    tvNoresults.isVisible = true
                } else {
                    tvNoresults.isVisible = false
                }
            }
        }
    }

    private fun announceNetworkStatus(networkStatus: Int) {
        val snackBarView = Snackbar.make(binding.root, networkStatus, Snackbar.LENGTH_LONG)
        val view = snackBarView.view
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.BOTTOM
        view.layoutParams = params
        snackBarView.animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
        snackBarView.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}