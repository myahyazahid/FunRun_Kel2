package com.upn.catatlari.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.upn.catatlari.databinding.ItemRunBinding
import com.upn.catatlari.model.Run

class RunAdapter(
    private val onEditClick: (Run) -> Unit = {},
    private val onDeleteClick: (Run) -> Unit = {}
) : RecyclerView.Adapter<RunAdapter.RunViewHolder>() {

    private var runList: List<Run> = emptyList()

    fun setData(data: List<Run>) {
        runList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RunViewHolder {
        val binding = ItemRunBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RunViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) {
        holder.bind(runList[position])
    }

    override fun getItemCount() = runList.size

    inner class RunViewHolder(private val binding: ItemRunBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(run: Run) {
            binding.txtRunDate.text = run.runDate
            binding.txtRunDistance.text = "${run.runDistance} km"
            binding.txtRunDuration.text = "${run.runDuration} mnt"

            // Edit button
            binding.btnEdit.setOnClickListener {
                onEditClick(run)
            }

            // Delete button dengan konfirmasi dialog
            binding.btnDelete.setOnClickListener {
                AlertDialog.Builder(binding.root.context)
                    .setTitle("Hapus Data")
                    .setMessage("Yakin ingin menghapus catatan lari tanggal ${run.runDate}?")
                    .setPositiveButton("Hapus") { _, _ ->
                        onDeleteClick(run)
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        }
    }
}