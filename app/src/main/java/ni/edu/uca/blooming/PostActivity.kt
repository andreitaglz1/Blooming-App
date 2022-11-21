package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.blooming.databinding.ActivityMainBinding
import ni.edu.uca.blooming.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}