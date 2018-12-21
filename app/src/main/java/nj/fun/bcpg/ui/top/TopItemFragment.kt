package nj.`fun`.bcpg.ui.top

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import nj.`fun`.bcpg.ContainerActivity
import nj.`fun`.bcpg.R
import nj.`fun`.bcpg.dt.VMList
import nj.`fun`.bcpg.dt.VMList.VMItem

class TopItemFragment : Fragment() {


    private var listenerTop: OnTopListFragmentInteractionListener? = object : OnTopListFragmentInteractionListener {
        override fun onListFragmentInteraction(item: VMItem?) {
            item ?: return

            ContainerActivity.launch(activity as AppCompatActivity, item.id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_topitem_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = MyTopItemRecyclerViewAdapter(VMList.ITEMS, listenerTop)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnTopListFragmentInteractionListener) {
//            listenerTop = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnTopListFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerTop = null
    }


    interface OnTopListFragmentInteractionListener {
        fun onListFragmentInteraction(item: VMItem?)
    }

    companion object {


        @JvmStatic
        fun newInstance() =
                TopItemFragment()
    }
}
