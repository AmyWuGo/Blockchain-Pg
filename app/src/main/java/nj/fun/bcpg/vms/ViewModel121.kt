package nj.`fun`.bcpg.vms

import android.app.Application
import io.rexx.crypto.Keypair
import io.rexx.model.request.AccountCheckValidRequest
import io.rexx.model.request.AccountGetInfoRequest
import io.rexx.model.request.AccountGetNonceRequest
import nj.`fun`.bcpg.base.BaseViewModel
import kotlin.concurrent.thread


class ViewModel121(appContext: Application) : BaseViewModel(appContext) {
    /**
     * Generate new key pair and validate addresses.
     */
    override fun onAction_1_Clicked() {
        thread(start = true) {

            val keypair = Keypair.generator()
            msg =
                    " keypair.getPrivateKey() " + keypair.privateKey + "\n" +
                    " keypair.getPublicKey() " + keypair.publicKey + "\n" +
                    " keypair.getAddress() " + keypair.address + "\n"

            printLogs(msg)
            printLogs("start validating address:" + "\n")

            Thread.sleep(300)
            checkAccountAddress(keypair.address)

            addressList4Test.forEach {
                Thread.sleep(400)

                checkAccountAddress(it)
            }
        }
    }

    /**
     * getInfo
     */
    override fun onAction_2_Clicked() {
        thread(start = true) {
            check_getInfo(Keypair.generator().address)

            addressList4Test.forEach {
                Thread.sleep(400)
                check_getInfo(it)
            }
        }
    }


    /**
     * getNonce
     */
    override fun onAction_3_Clicked() {

        thread(start = true) {
            check_getNonce(Keypair.generator().address)

            addressList4Test.forEach {
                Thread.sleep(400)
                check_getNonce(it)
            }
        }

    }


    private fun check_getNonce(targetAddress: String) {

        val getNonceRequest = AccountGetNonceRequest()
        getNonceRequest.address = targetAddress

        val getNonceResponse = sdk.accountService.getNonce(getNonceRequest)
        if (getNonceResponse.errorCode == 0) {
            val result = getNonceResponse.result
            printLogs("nonce: " + result.nonce!!)
        } else {
            printLogs("error" + getNonceResponse.errorDesc)
        }

    }

    private fun check_getInfo(targetAddress: String) {

        val request = AccountGetInfoRequest()
        request.address = targetAddress

        val response = sdk.accountService.getInfo(request)
        if (response.errorCode == 0) {
            printLogs(response.result.toString())
        } else {
            printLogs("error: " + response.errorDesc)
        }
    }


    private fun checkAccountAddress(targetAddress: String) {

        val request = AccountCheckValidRequest()
        request.address = targetAddress

        val response = sdk.getAccountService().checkValid(request)
        if (0 == response.getErrorCode()) {
            printLogs("response:" + response.getResult().isValid())
        } else {
            printLogs("error: " + response.errorDesc)
        }
    }
}
