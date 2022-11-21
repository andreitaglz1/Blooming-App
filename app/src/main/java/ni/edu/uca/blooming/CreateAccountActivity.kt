package ni.edu.uca.blooming

import UserViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ni.edu.uca.blooming.data.User
import ni.edu.uca.blooming.databinding.ActivityCreateAccountBinding
import ni.edu.uca.blooming.databinding.ActivityLoginBinding

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel

    private lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnSignUp.setOnClickListener {
            insertDataToDataBase()
        }

    }

    private fun insertDataToDataBase() {
        val username = binding.etNombre.text.toString()
        val pwd = binding.etPassword.text.toString()

        if (inputCheck(username, pwd)) {
        //Se crea un objeto usuario
            val user =  User(0, username, pwd)
            //Añadir datos a la database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Cuenta añadida exitosamente", Toast.LENGTH_LONG).show()
            //Regresar a login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }else(
                Toast.makeText(this, "Por favor llene los campos", Toast.LENGTH_LONG).show()
        )
    }

    private fun inputCheck(username: String, pwd: String): Boolean{
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(pwd))
    }
}