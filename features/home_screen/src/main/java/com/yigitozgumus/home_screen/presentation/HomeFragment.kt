package com.yigitozgumus.home_screen.presentation

import androidx.fragment.app.viewModels
import com.yigitozgumus.base_feature.base.BaseFragment
import com.yigitozgumus.base_feature.base.BaseViewModel
import com.yigitozgumus.base_feature.content.BindingInflater
import com.yigitozgumus.home_screen.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment() {

    override val viewModel: BaseViewModel by viewModels()

    override val bindingInflater = BindingInflater(FragmentHomeBinding::inflate) {
        titleText.text = "Home Screen"
    }

}
