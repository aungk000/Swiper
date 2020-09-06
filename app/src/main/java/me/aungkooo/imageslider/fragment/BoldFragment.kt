package me.aungkooo.imageslider.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import me.aungkooo.imageslider.R
import me.aungkooo.imageslider.databinding.FragmentBoldBinding

/**
 * Created by User on 30/5/2018.
 */

class BoldFragment : Fragment() {
    private var binding: FragmentBoldBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentBoldBinding.inflate(inflater, container, false)
        var view: View? = null
        binding?.let { fragmentBoldBinding ->
            view = fragmentBoldBinding.root
            fragmentBoldBinding.txtBold.setText(R.string.material_design_principles_bold)
            val context = context
            if (context != null) {
                Picasso.with(getContext()).load(R.drawable.materialdesign_principles_bold).into(fragmentBoldBinding.imgBold)
                binding!!.relativeLayoutBold.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}