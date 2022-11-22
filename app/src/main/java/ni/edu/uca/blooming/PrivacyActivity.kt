package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.blooming.databinding.ActivityPrivacyBinding

class PrivacyActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPrivacyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_privacy)

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this@PrivacyActivity, MainActivity::class.java))
        }
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this@PrivacyActivity, InfoAccountActivity::class.java))
        }
    }
}