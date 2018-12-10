package nj.`fun`.bcpg.vms

import android.app.Application
import nj.`fun`.bcpg.base.BaseViewModel

open class ViewModelDefault(appContext : Application) : BaseViewModel(appContext) {

    override fun onAction_1_Clicked() {
        outputMessage.value = "1"
    }

    override fun onAction_2_Clicked() {
        outputMessage.value = "2"
    }

    override fun onAction_3_Clicked() {
        outputMessage.value = "3"
    }
}
