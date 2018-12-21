package nj.`fun`.bcpg.vms

import android.app.Application
import com.alibaba.fastjson.JSON
import io.rexx.common.ToBaseUnit
import io.rexx.crypto.Keypair
import io.rexx.model.request.AccountGetBalanceRequest
import io.rexx.model.request.AccountGetMetadataRequest
import nj.`fun`.bcpg.base.BaseViewModel
import kotlin.concurrent.thread






class ViewModel122(appContext: Application) : BaseViewModel(appContext) {


    /**
     *　getBalance
     */
    override fun onAction_1_Clicked() {

        thread(start = true) {
            check_getBalance(Keypair.generator().address)

            addressList4Test.forEach {
                Thread.sleep(400)
                check_getBalance(it)
            }
        }
    }


    override fun onAction_2_Clicked() {
        thread(start = true) {
            check_getMetadata(Keypair.generator().address)

            addressList4Test.forEach {
                Thread.sleep(400)
                check_getMetadata(it)
            }
        }
    }

    override fun onAction_3_Clicked() {

    }


    private fun check_getMetadata(targetAddress: String) {

        val request = AccountGetMetadataRequest()
        request.address = targetAddress
//        request.key = "20181219"

        val response = sdk.accountService.getMetadata(request)
        if (response.errorCode == 0) {
            val result = response.result
            printLogs(JSON.toJSONString(result, true))
        } else {
            printLogs("error: " + response.errorDesc)
        }

    }



    private fun check_getBalance(targetAddress: String) {

        val request = AccountGetBalanceRequest()
        request.address = targetAddress
        val response = sdk.accountService.getBalance(request)

        if (0 == response.errorCode) {
            val result = response.result
            printLogs("REX balance：" + ToBaseUnit.RexxLess8(result.balance!!.toString()) + " REX")
        } else {
            printLogs("error: " + response.errorDesc)
        }

    }

}
