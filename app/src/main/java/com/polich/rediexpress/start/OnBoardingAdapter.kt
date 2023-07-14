package com.polich.rediexpress.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.polich.rediexpress.R
import com.polich.rediexpress.databinding.ItemOnboardingBinding

class OnBoardingAdapter(private val onBoardings: Array<OnBoarding>, val showLastButton: (Boolean) -> Unit,):
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardings[position], position)
    }

    override fun getItemCount() = onBoardings.size

    inner class OnBoardingViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemOnboardingBinding.bind(view)

        fun bind(onBoarding: OnBoarding, position: Int){
            binding.imageView.setImageResource(onBoarding.img)
            binding.textBodyOnb.text = onBoarding.text
            binding.titleOnb.text = onBoarding.title
//            if (position == onBoardings.lastIndex) {
//                showLastButton(true)
//            } else showLastButton(false)
        }
    }
}


data class OnBoarding(val title : String, val text: String, @DrawableRes val img: Int)