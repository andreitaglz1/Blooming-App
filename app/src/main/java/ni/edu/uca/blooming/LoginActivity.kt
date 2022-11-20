package ni.edu.uca.blooming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ni.edu.uca.blooming.databinding.ActivityCreateAccountBinding
import ni.edu.uca.blooming.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val auth = Firebase.auth
        binding.btnLogin.setOnClickListener {
            val usuario: String = binding.etNombre.text.toString().trim()
            val pwd: String = binding.etPassword.text.toString().trim()

            auth.signInWithEmailAndPassword(usuario, pwd).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Has iniciado sesión", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ha habido un error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

