package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ni.edu.uca.blooming.databinding.ActivityTerminosyCondicionesBinding

class TerminosyCondiciones : AppCompatActivity() {
    private lateinit var binding: ActivityTerminosyCondicionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerminosyCondicionesBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this@TerminosyCondiciones, MainActivity::class.java))
        }
        binding.btnUser.setOnClickListener {
            startActivity(Intent(this@TerminosyCondiciones, InfoAccountActivity::class.java))
        }
    }
}