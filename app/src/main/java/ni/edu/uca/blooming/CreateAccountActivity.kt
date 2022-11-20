package ni.edu.uca.blooming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import ni.edu.uca.blooming.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val auth = Firebase.auth
        binding.btnSignUp.setOnClickListener {
            val usuario: String = binding.etNombre.text.toString().trim()
            val pwd: String = binding.etPassword.text.toString().trim()

            auth.createUserWithEmailAndPassword(usuario, pwd).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Ha habido un error", Toast.LENGTH_SHORT).show()
                }
            }
        }



    }
    

}