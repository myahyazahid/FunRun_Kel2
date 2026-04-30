package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.viewmodel.RunViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilkan email user di greeting
        val user = (activity as MainActivity).user
        binding.tvUserName.text = "Halo, ${user?.email}!"

        // FAB navigasi ke AddRunFragment
        binding.fabAddRun.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToAddRunFragment()
            )
        }

        // Setup RecyclerView
        val runAdapter = RunAdapter()
        binding.rvRuns.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRuns.adapter = runAdapter

        // Observe data
        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)

            // Tampilkan/sembunyikan empty state
            if (runList.isEmpty()) {
                binding.emptyState.visibility = View.VISIBLE
                binding.rvRuns.visibility = View.GONE
            } else {
                binding.emptyState.visibility = View.GONE
                binding.rvRuns.visibility = View.VISIBLE
            }
        }
    }
}