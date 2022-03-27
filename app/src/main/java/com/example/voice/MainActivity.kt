package com.example.voice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voice.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.vk.api.sdk.VK
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var layoutManager: LinearLayoutManager? = null
    var listsAdapter: CustomRecyclerAdapter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomRecyclerAdapter(List())


        if (!VK.isLoggedIn()) {
            AuthorisationActivity.start(this)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Запись аудио", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        fun List(): MutableList<String> {
            val data = mutableListOf<String>()
            (0..30).forEach { i -> data.add("$i element") }
            return data
        }
    }
}