package com.yigitozgumus.base_feature.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.yigitozgumus.base_feature.content.BaseLayoutInflater

abstract class BaseFragment : Fragment() {

    protected abstract val bindingInflater: BaseLayoutInflater

    protected abstract val viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.onBackPressed()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return bindingInflater.inflate(inflater, container)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingInflater.releaseResources()
    }

}
