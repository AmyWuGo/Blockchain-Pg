package nj.`fun`.bcpg

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import nj.`fun`.bcpg.ui.fragm.ContainerFragment1

class ContainerActivity : AppCompatActivity(), ContainerFragment1.OnContainerFragment1Listener {
    override fun onContainerFragment1Interaction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ContainerFragment1.newInstance())
                    .commitNow()
        }
    }

}
