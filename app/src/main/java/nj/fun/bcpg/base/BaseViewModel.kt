package nj.`fun`.bcpg.base

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.rexx.SDK


abstract class BaseViewModel(private val appContext: Application) : AndroidViewModel(appContext) {
    var msg: String? = null
    var address: String? = null

    val addressList4Test = arrayOf(
            "Rexxhs5eGe6pPsZheQMpkMksyV74tQJCkYhruMq",
            "Rexxhrvn7p589QRQ2QYcdGu8xdUp2Dtue44WQjJ",
            "Rexx",
            "5h",
            "Rexxhrvn7p5890RQ2QYcdGu8xdUp2Dtue44WQjJ",
            "RexxhryHE8mXNjFseuu17rawgYewc4WDEendQYc"
            )

    val sdk = SDK.getInstance("http://54.199.245.14:16002")


    val outputMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun showToast(msg: String?) {
        msg ?: return

        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show()

    }

    fun printLogs(msg: String?) {
        msg ?: return

        outputMessage.postValue("\n" + msg)
        Log.d("debugRexx", "\n" + msg)

    }



//    thread(start = true) {
//
//        Thread.sleep(400)
//
//
//        printLogs("test")
//    }

    abstract fun onAction_1_Clicked()
    abstract fun onAction_2_Clicked()
    abstract fun onAction_3_Clicked()
}
