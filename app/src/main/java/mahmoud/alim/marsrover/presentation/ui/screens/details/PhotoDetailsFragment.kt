package mahmoud.alim.marsrover.presentation.ui.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import dagger.hilt.android.AndroidEntryPoint
import mahmoud.alim.marsrover.R
import mahmoud.alim.marsrover.databinding.FragmentPhotoDetailsBinding

@AndroidEntryPoint
class PhotoDetailsFragment : Fragment() {

    private var _binding: FragmentPhotoDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<PhotoDetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val photo = args.photoDetails
        binding.apply {
            Glide.with(this@PhotoDetailsFragment)
                .load(photo.imageSrc)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.ic_baseline_error)
                .into(binding.ivPhoto)

            tvPhotoDate.text = photo.earthDate
            tvRoverName.text = photo.roverName
            tvCameraName.text = photo.cameraName
            launchDate.date = photo.launchDate
            landDate.date = photo.landingDate
            tvStatus.text = photo.status
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}