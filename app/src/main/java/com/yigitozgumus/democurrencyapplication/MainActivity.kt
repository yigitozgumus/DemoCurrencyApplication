package com.yigitozgumus.democurrencyapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.yigitozgumus.democurrencyapplication.databinding.ActivityFragmentContainerBinding
import com.yigitozgumus.home_screen.presentation.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

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
}
