package mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import mahmoud.alim.marsrover.databinding.RoverLoadStateFooterBinding

/**
 * @author Mahmoud Alim on 19/12/2022.
 */

class RoverPhotoLoadStateAdapter (private val retry: ()-> Unit):
        LoadStateAdapter<RoverPhotoLoadStateAdapter.LoadStateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = RoverLoadStateFooterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return LoadStateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }


    inner class LoadStateViewHolder(private val binding: RoverLoadStateFooterBinding) :
            RecyclerView.ViewHolder(binding.root) {


        init {
            binding.buttonRetryLoad.setOnClickListener {
                 retry.invoke()
            }

        }
        fun bind(loadState: LoadState) {
            binding.apply {
                progressBarLoad.isVisible = loadState is LoadState.Loading
                buttonRetryLoad.isVisible = loadState !is LoadState.Loading
                tvErrorLoad.isVisible = loadState !is LoadState.Loading
            }

        }
    }
}