package nj.`fun`.bcpg.ui.top

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import nj.`fun`.bcpg.ui.top.TopItemFragment.OnTopListFragmentInteractionListener
import nj.`fun`.bcpg.dt.VMList.VMItem

import kotlinx.android.synthetic.main.fragment_top_item.view.*
import nj.`fun`.bcpg.R


class MyTopItemRecyclerViewAdapter(
        private val mValues: List<VMItem>,
        private val mListener: OnTopListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyTopItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as VMItem
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_top_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.content

    }
}
