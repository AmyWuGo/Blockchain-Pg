package nj.`fun` .bcpg.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    val outputMessage: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    abstract fun onAction_1_Clicked()
    abstract fun onAction_2_Clicked()
    abstract fun onAction_3_Clicked()
}
