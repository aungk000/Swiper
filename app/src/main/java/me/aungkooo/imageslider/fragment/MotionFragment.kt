package me.aungkooo.imageslider.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import me.aungkooo.imageslider.R
import me.aungkooo.imageslider.databinding.FragmentMotionBinding

/**
 * Created by User on 30/5/2018.
 */
class MotionFragment : Fragment() {
    private var binding: FragmentMotionBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMotionBinding.inflate(inflater, container, false)

        var view: View? = null

        binding?.let { fragmentMotionBinding ->
            view = fragmentMotionBinding.root
            fragmentMotionBinding.txtMotion.setText(R.string.material_design_principles_motion)
            val context = context
            if (context != null) {
                Picasso.with(context).load(R.drawable.materialdesign_principles_motion).into(fragmentMotionBinding.imgMotion)
                fragmentMotionBinding.relativeLayoutMotion.setBackgroundColor(ContextCompat.getColor(context, R.color.white))
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}