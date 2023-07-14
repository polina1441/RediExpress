package com.polich.rediexpress.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.polich.rediexpress.R

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val thread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(1500)
                    requireActivity().runOnUiThread {
                        findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        thread.start()
    }
}