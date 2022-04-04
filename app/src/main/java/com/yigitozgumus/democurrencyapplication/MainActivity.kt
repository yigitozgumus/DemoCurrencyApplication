/*
 * Created by yigitozgumus on 4/2/22, 11:44 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 11:44 AM
 */

package com.yigitozgumus.democurrencyapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.yigitozgumus.democurrencyapplication.databinding.ActivityFragmentContainerBinding
import com.yigitozgumus.democurrencyapplication.navigation.NavigatorDelegate
import com.yigitozgumus.home_screen.presentation.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigatorDelegate {

    private lateinit var binding: ActivityFragmentContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
        supportFragmentManager.commit {
            add(R.id.fragment_container, HomeFragment())
            setReorderingAllowed(true)
        }
        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun navigateTo(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
            setReorderingAllowed(true)
        }
    }
}
