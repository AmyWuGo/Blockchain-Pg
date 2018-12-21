package nj.`fun`.bcpg.vms

import android.app.Application
import nj.`fun`.bcpg.base.BaseViewModel
import nj.`fun`.bcpg.util.UtilAddress
import org.bitcoinj.core.ECKey
import org.bitcoinj.params.TestNet2Params


class ViewModel100(appContext: Application) : BaseViewModel(appContext) {

    override fun onAction_1_Clicked() {
        val networkParameters = TestNet2Params.get()
//        val networkParameters = MainNetParams.get()

        msg = "Generated a Bitcoin address for TestNet2"
        showToast(msg)

        val key = ECKey()
        address = key.toAddress(networkParameters).toString()

        var output = "private key => " + key.privateKeyAsHex + "\n" +
                "public key => " + key.publicKeyAsHex + "\n" +
                "address => " + address + "\n"
        outputMessage.value = output


        printLogs(msg)
        printLogs(output)
        printLogs("address is :" + UtilAddress.validateBitcoinAddress(address))
        // https://blog.csdn.net/wypeng2010/article/details/81325743
    }

    override fun onAction_2_Clicked() {
        outputMessage.value = "2"
    }

    override fun onAction_3_Clicked() {
        outputMessage.value = "3"
    }
}
