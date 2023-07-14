package com.polich.rediexpress.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.polich.rediexpress.R
import com.polich.rediexpress.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val onBoardings : Array<OnBoarding> = arrayOf(
        OnBoarding("", "Enjoy quick pick-up and delivery to your destination", R.drawable.onb1, ),
        OnBoarding("Flexible Payment", "Different modes of payment either before and after delivery without stress", R.drawable.onb2, ),
        OnBoarding("Real-time Tracking", "", R.drawable.onb3, ),
    )

    lateinit var binding : FragmentOnBoardingBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnBoardingBinding.bind(view)
        binding.viewPageOnboarding.adapter = OnBoardingAdapter(onBoardings)
            { showLastButton(it) }
        binding.dots.attachTo(binding.viewPageOnboarding)

        binding.skipOnb.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_createAccountFragment)
        }

        binding.nextOnb.setOnClickListener {
            val page = binding.viewPageOnboarding.getCurrentItem()
            binding.viewPageOnboarding.setCurrentItem(page+1)
        }
    }

    fun showLastButton(isVisible: Boolean){
        if (isVisible){
            binding.lastPageButton.visibility = View.VISIBLE
            binding.buttons.visibility = View.GONE
        } else {
            binding.lastPageButton.visibility = View.GONE
            binding.buttons.visibility = View.VISIBLE
        }
    }
}