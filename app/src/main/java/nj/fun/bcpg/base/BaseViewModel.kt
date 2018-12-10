package nj.`fun`.bcpg.base

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel(private val appContext: Application) : AndroidViewModel(appContext) {
    var output: String? = null
    var msg: String? = null
    var address: String? = null

    val outputMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun showToast(msg: String?) {
        msg ?: return

        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show()

    }

    fun printLogs(msg: String?) {
        Log.d("debugRexx", "\n" + msg)

    }

    abstract fun onAction_1_Clicked()
    abstract fun onAction_2_Clicked()
    abstract fun onAction_3_Clicked()
}
