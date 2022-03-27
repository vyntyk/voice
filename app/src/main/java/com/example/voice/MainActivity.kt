package com.example.voice

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore.Audio.Media
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voice.databinding.ActivityMainBinding
import com.vk.api.sdk.VK
import java.io.File

const val ACTIVITY_RECORD_SOUND = 0

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var progressBar: ProgressBar? = null
    var layoutManager: LinearLayoutManager? = null
    var listsAdapter: CustomRecyclerAdapter? = null

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!VK.isLoggedIn()) {
            AuthorisationActivity.start(this)
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            val intent = Intent(Media.RECORD_SOUND_ACTION)
            startActivityForResult(intent, ACTIVITY_RECORD_SOUND)
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CustomRecyclerAdapter(ArrayList())
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var path: String = "/media/external/audio/media/"
        File(path).walk(FileWalkDirection.TOP_DOWN)
            .forEach {
                Log.d("myLog", it.name)

            }

    }
}




