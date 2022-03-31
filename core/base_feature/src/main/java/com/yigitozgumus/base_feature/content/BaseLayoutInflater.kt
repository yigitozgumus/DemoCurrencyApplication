package com.yigitozgumus.base_feature.content

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface BaseLayoutInflater {
    fun inflate(layoutInflater: LayoutInflater, container: ViewGroup?): View
    fun releaseResources()
}

class BindingInflater<VB : ViewBinding>(
    private val layoutInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    private val initBindingUIFunc: VB.() -> Unit = {}
) : BaseLayoutInflater {

    private var _binding: VB? = null
    private val binding get() = _binding!!

    override fun inflate(layoutInflater: LayoutInflater, container: ViewGroup?): View {
        _binding = layoutInflater(layoutInflater, container, false)
        initBindingUIFunc(binding)
        return binding.root
    }

    override fun releaseResources() {
        _binding = null
    }

}
