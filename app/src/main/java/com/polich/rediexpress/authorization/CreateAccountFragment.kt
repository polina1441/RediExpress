package com.polich.rediexpress.authorization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.polich.rediexpress.R
import com.polich.rediexpress.databinding.FragmentCreateAccountBinding

class CreateAccountFragment: Fragment(R.layout.fragment_create_account) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCreateAccountBinding.bind(view)
    }
}