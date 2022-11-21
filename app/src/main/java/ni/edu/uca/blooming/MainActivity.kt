package ni.edu.uca.blooming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import ni.edu.uca.blooming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //for nav drawer
        toogle = ActionBarDrawerToggle(this, binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //for navigation
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navUsability -> startActivity(Intent(this@MainActivity,UsabilityActivity::class.java))
                R.id.navHelp -> startActivity(Intent(this@MainActivity,HelpActivity::class.java))
                R.id.navPrivacy -> startActivity(Intent(this@MainActivity, PrivacyActivity::class.java))
                R.id.navTerminos ->startActivity(Intent(this@MainActivity, TerminosyCondiciones::class.java))
            }
            true
        }

        binding.btnPost.setOnClickListener{
            startActivity(Intent(this@MainActivity, PostActivity::class.java))
        }

    }
}
