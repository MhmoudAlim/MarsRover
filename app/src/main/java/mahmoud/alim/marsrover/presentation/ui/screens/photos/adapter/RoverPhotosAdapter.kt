package mahmoud.alim.marsrover.presentation.ui.screens.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import mahmoud.alim.marsrover.R
import mahmoud.alim.marsrover.databinding.RoverItemBinding
import mahmoud.alim.marsrover.domain.model.RoverPhoto

/**
 * @author Mahmoud Alim on 19/12/2022.
 */

class RoverPhotosAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<RoverPhoto, RoverPhotosAdapter.PhotoViewHolder>(differCallback) {

    inner class PhotoViewHolder(private val binding: RoverItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(photo: RoverPhoto) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.imageSrc)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(android.R.drawable.ic_menu_report_image)
                    .error(R.drawable.ic_baseline_error)
                    .into(ivPhoto)
                tvRoverName.text = photo.roverName
                tvCameraName.text = photo.cameraName
                tvPhotoDate.text = photo.earthDate
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(photo: RoverPhoto)
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<RoverPhoto>() {
            override fun areItemsTheSame(
                oldItem: RoverPhoto,
                newItem: RoverPhoto
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: RoverPhoto,
                newItem: RoverPhoto
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            RoverItemBinding.inflate(
                /* inflater = */ LayoutInflater.from(parent.context),
                /* parent = */ parent,
                /* attachToParent = */ false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) holder.bind(currentItem)
    }
}