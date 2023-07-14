package com.polich.rediexpress.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.polich.rediexpress.R
import com.polich.rediexpress.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {
    private val onBoardings : Array<OnBoarding> = arrayOf(
        OnBoarding("", "Enjoy quick pick-up and delivery to your destination", R.drawable.onb1, false),
        OnBoarding("Flexible Payment", "Different modes of payment either before and after delivery without stress", R.drawable.onb2, false),
        OnBoarding("Real-time Tracking", "", R.drawable.onb3, true),
    )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentOnBoardingBinding.bind(view)
        binding.viewPageOnboarding.adapter = OnBoardingAdapter(onBoardings)
        binding.dots.attachTo(binding.viewPageOnboarding)

        binding.skipOnb.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFragment_to_createAccountFragment)
        }

        binding.nextOnb.setOnClickListener {
            val page = binding.viewPageOnboarding.getCurrentItem()
            binding.viewPageOnboarding.setCurrentItem(page+1)
        }
    }
}