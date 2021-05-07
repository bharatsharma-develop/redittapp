package com.example.bharatreddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.example.bharatreddit.view.CharacterListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progress_bar)

        supportFragmentManager.beginTransaction().replace(
                R.id.container_fragment,
                CharacterListFragment()
        ).commit()
    }

    fun showProgressBar(loading: Boolean){
        if(loading) progressBar.visibility = View.GONE
        else progressBar.visibility = View.VISIBLE
    }
}