package nj.`fun`.bcpg.ui.top

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nj.`fun`.bcpg.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, TopItemFragment.newInstance())
                    .commitNow()
        }
    }
}
