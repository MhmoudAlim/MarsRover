package mahmoud.alim.marsrover.presentation.ui.screens.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import mahmoud.alim.marsrover.databinding.FragmentPhotosBinding
import mahmoud.alim.marsrover.domain.model.RoverPhoto
import mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter.RoverPhotoLoadStateAdapter
import mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter.RoverPhotosAdapter

@AndroidEntryPoint
class PhotosFragment : Fragment(), RoverPhotosAdapter.OnItemClickListener {

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PhotosViewModel by viewModels()

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

        val photoAdapter = RoverPhotosAdapter(this)
        setupRecycler(photoAdapter)

        lifecycleScope.launch {
            viewModel.photos.distinctUntilChanged().collectLatest {
                photoAdapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }


    override fun onItemClick(photo: RoverPhoto) {

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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}