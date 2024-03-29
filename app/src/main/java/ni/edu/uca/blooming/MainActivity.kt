package ni.edu.uca.blooming

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import ni.edu.uca.blooming.adaptadores.PostAdapter
import ni.edu.uca.blooming.adaptadores.PostList
import ni.edu.uca.blooming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //for nav drawer
        toggle = ActionBarDrawerToggle(this, binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
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


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

 /*   fun nuevo() {
        val intent = Intent(this@MainActivity,PostActivity::class.java)
        startActivity(intent)
    }*/
}
