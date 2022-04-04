/*
 * Created by yigitozgumus on 4/4/22, 10:17 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/4/22, 10:17 PM
 */

package com.yigitozgumus.detail_screen.presentation

import androidx.fragment.app.viewModels
import com.yigitozgumus.base_feature.base.BaseFragment
import com.yigitozgumus.base_feature.content.BindingInflater
import com.yigitozgumus.detail_screen.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    override val bindingInflater = BindingInflater(FragmentDetailBinding::inflate)

    override val viewModel: DetailViewModel by viewModels()

}
