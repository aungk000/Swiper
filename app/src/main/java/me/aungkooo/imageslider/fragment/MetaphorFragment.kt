package me.aungkooo.imageslider.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import me.aungkooo.imageslider.R
import me.aungkooo.imageslider.databinding.FragmentMetaphorBinding

/**
 * Created by User on 30/5/2018.
 */
class MetaphorFragment : Fragment() {

    private var binding: FragmentMetaphorBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentMetaphorBinding.inflate(inflater, container, false)

        var view: View? = null
        binding?.let { fragmentMetaphorBinding ->
            view = fragmentMetaphorBinding.root
            fragmentMetaphorBinding.txtMetaphor.setText(R.string.material_design_principles_metaphor)
            val context = context
            if (context != null) {
                Picasso.with(getContext()).load(R.drawable.materialdesign_principles_metaphor).into(fragmentMetaphorBinding.imgMetaphor)
                fragmentMetaphorBinding.relativeLayoutMetaphor.setBackgroundColor(ContextCompat.getColor(context, R.color.light_blue))
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}