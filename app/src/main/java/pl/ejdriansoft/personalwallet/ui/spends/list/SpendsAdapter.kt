package pl.ejdriansoft.personalwallet.ui.spends.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.ejdriansoft.personalwallet.R
import pl.ejdriansoft.personalwallet.data.SpendEntity


class SpendsAdapter(private val spendList: List<SpendEntity>) : RecyclerView.Adapter<SpendsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spend, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = spendList[position]
        holder.tvCategory.text = item.comment
    }

    override fun getItemCount(): Int {
        return spendList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvCategory: TextView = view.findViewById(R.id.tvCategory)
        var tvPrice: TextView = view.findViewById(R.id.tvPrice)
    }
}