package nj.`fun`.bcpg.dt

import nj.`fun`.bcpg.vms.ViewModelDefault


object  VMList {
    data class VMItem(val id: Int, val content: String)

    const val KEY_VIEW_MODEL_INDEX = "key_view_model_index"

    const val VM_DEFAULT = 1
    const val VM_100 = 100


    val ITEMS: MutableList<VMItem> = arrayListOf(
            VMItem(VM_DEFAULT, "Default"),
            VMItem(VM_100, "Generate Bitcoin Address 1")
    )

}
