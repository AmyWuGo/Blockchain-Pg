package nj.`fun`.bcpg.ui.fragm

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_container_1.*
import nj.`fun`.bcpg.R
import nj.`fun`.bcpg.base.BaseViewModel
import nj.`fun`.bcpg.dt.VMList
import nj.`fun`.bcpg.dt.VMList.VM_100
import nj.`fun`.bcpg.dt.VMList.VM_121
import nj.`fun`.bcpg.dt.VMList.VM_122
import nj.`fun`.bcpg.dt.VMList.VM_DEFAULT
import nj.`fun`.bcpg.vms.ViewModel100
import nj.`fun`.bcpg.vms.ViewModel121
import nj.`fun`.bcpg.vms.ViewModel122
import nj.`fun`.bcpg.vms.ViewModelDefault


class ContainerFragment1 : Fragment() {
    private var viewModelIndex: Int? = null

    private lateinit var viewModel: BaseViewModel

    private var listenerContainer: OnContainerFragment1Listener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModelIndex = it.getInt(VMList.KEY_VIEW_MODEL_INDEX, VM_DEFAULT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_container_1, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnContainerFragment1Listener) {
            listenerContainer = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnContainerFragment1Listener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerContainer = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
        initVies()
    }

    private fun initVies() {
        output_txt.movementMethod = ScrollingMovementMethod();
        action_1.setOnClickListener { viewModel.onAction_1_Clicked() }
        action_2.setOnClickListener { viewModel.onAction_2_Clicked() }
        action_3.setOnClickListener { viewModel.onAction_3_Clicked() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(
                when (viewModelIndex) {
                    VM_DEFAULT -> ViewModelDefault::class.java
                    VM_100 -> ViewModel100::class.java
                    VM_121 -> ViewModel121::class.java
                    VM_122 -> ViewModel122::class.java
                    else -> ViewModelDefault::class.java
                }
        )

        viewModel.outputMessage.observe(this, Observer<String> { outputMsg ->
            outputMsg ?: return@Observer

            updateOutputMsg(outputMsg)
        })

    }

    private fun updateOutputMsg(outputMsg: String) {
        output_txt.append("$outputMsg \n")
    }


    interface OnContainerFragment1Listener {
        fun onContainerFragment1Interaction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(viewModelIndex: Int = VM_DEFAULT) =
                ContainerFragment1().apply {
                    arguments = Bundle().apply {
                        putInt(VMList.KEY_VIEW_MODEL_INDEX, viewModelIndex)
                    }
                }
    }
}

