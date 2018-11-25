package nj.`fun`.bcpg.dt


object VMList {
    data class VMItem(val id: Int, val content: String)

    const val  KEY_VIEW_MODEL_INDEX = "key_view_model_index"

    const val VM0001_DEFAULT = 1
    const val VM0002_XX = 2








   val ITEMS: MutableList<VMItem> = arrayListOf(
            VMItem(VM0001_DEFAULT, "Default")
    )
}
