package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.blooming.databinding.ActivityInfoAccountBinding

class InfoAccountActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInfoAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this@InfoAccountActivity, MainActivity::class.java))
        }
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this@InfoAccountActivity, InfoAccountActivity::class.java))
        }
    }
}