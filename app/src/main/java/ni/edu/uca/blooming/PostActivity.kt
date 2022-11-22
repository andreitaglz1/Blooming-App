package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ni.edu.uca.blooming.data.Bloom
import ni.edu.uca.blooming.data.BloomDatabase
import ni.edu.uca.blooming.databinding.ActivityMainBinding
import ni.edu.uca.blooming.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPubBloom.setOnClickListener { addBloom() }

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this@PostActivity, MainActivity::class.java))
        }
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this@PostActivity, InfoAccountActivity::class.java))
        }
        binding.btnPubBloom.setOnClickListener {
            startActivity(Intent(this@PostActivity, MainActivity::class.java))
        }
    }

        private fun addBloom(){
            val textBloom = binding.edBloom.text.toString()


            lifecycleScope.launch(){
                val bloom = Bloom(textBloom = textBloom)
                BloomDatabase(this@PostActivity).getBloomDao().addBloom(bloom)
                finish()
            }
        }

    /*override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val bloomList = BloomDatabase(this@PostActivity).getBloomDao().getAllBloom()
            Log.e("oooooo", "onResume: ${bloomList.size}")
        }
    }*/


}