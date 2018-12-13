package nj.`fun`.bcpg.vms

import android.app.Application
import io.bumo.encryption.key.PrivateKey
import io.bumo.encryption.key.PublicKey
import nj.`fun`.bcpg.base.BaseViewModel
import io.bumo.encryption.model.KeyType
import java.util.*
import android.R.attr.src




class ViewModel121(appContext: Application) : BaseViewModel(appContext) {
    //rawPrivateKey: [25, 51, -9, 52, -4, -83, -114, -3, 2, 77, 47, -89, 112, -40, -100, -87, -103, 99, 54, 23, 82, 74, 106, 40, 3, -79, 77, 82, 90, 42, -58, 60]

    val encPrivateKey = "privbsWi7woYzw53N7Dmyhd3mpvKFRWxP8aGo8mygBGkenvh3br3cLXN"
    val encPublicKey = "b001396e8788d402e8c1f8012f996e5783e123b453613c6b3487f0e18360c73d9f27807d4dba"
    val encAddress = "buQkFni6XKxkGEdjBG4URcTxk53Rjf2rgeF2"


    override fun onAction_1_Clicked() {
        msg = "Generated a BUMO  ED25519 keyPair"
        showToast(msg)

        val key = PrivateKey(KeyType.ED25519)

        output = "rawPrivateKey: " + Arrays.toString(key.rawPrivateKey) + "\n\n" +
                "encPrivateKey: " + key.encPrivateKey + "\n\n" +
                "encPublicKey: " + key.encPublicKey + "\n\n" +
                "encAddress: " + key.encAddress + "\n\n\n"

        outputMessage.value = output


        printLogs(msg)
        printLogs(output)
    }

    override fun onAction_2_Clicked() {

        val key = PrivateKey(encPrivateKey)

        output = "rawPrivateKey: " + Arrays.toString(key.rawPrivateKey) + "\n\n" +
                "encPrivateKey: " + key.encPrivateKey + "\n\n" +
                "encPublicKey: " + key.encPublicKey + "\n\n" +
                "encAddress: " + key.encAddress + "\n\n\n"
        printLogs(output)


        val src = "test"
        val sign = key.sign(src.toByteArray())

        output = "sign: " + Arrays.toString(sign) + "\n\n"
        printLogs(output)


        val publicKey = PublicKey(encPublicKey)
        val verifyResult = publicKey.verify(src.toByteArray(), sign)
        output = "verifyResult: $verifyResult\n\n"
        printLogs(output)
    }

    override fun onAction_3_Clicked() {
        outputMessage.value = "3"
    }
}
