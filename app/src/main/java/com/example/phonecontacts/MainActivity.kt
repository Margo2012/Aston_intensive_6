package com.example.phonecontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phonecontacts.databinding.ActivityMainBinding
import com.example.phonecontacts.fragments.ContactsFragment

private const val FRAGMENT_TAG = "TAG"

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private val fragment = ContactsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportFragmentManager.findFragmentByTag(FRAGMENT_TAG) == null) {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment, FRAGMENT_TAG)
                commit()
            }
        }
    }
}


