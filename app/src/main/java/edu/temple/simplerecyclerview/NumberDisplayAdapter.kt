package edu.temple.simplerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberDisplayAdapter(
    private val numbers: Array<Int>,
    private val clickListener: (Int) -> Unit  // Accept lambda
) : RecyclerView.Adapter<NumberDisplayAdapter.NumberViewHolder>() {

    inner class NumberViewHolder(layout: View) : RecyclerView.ViewHolder(layout) {
        val textView: TextView = layout.findViewById(R.id.textView)

        init {
            layout.setOnClickListener {
                val number = numbers[adapterPosition]
                clickListener(number)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.textview_layout, parent, false)
        return NumberViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.textView.text = numbers[position].toString()
    }
}
