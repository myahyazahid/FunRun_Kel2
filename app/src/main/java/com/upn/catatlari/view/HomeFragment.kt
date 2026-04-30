package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.viewmodel.RunViewModel
import com.upn.catatlari.viewmodel.RunViewModelFactory

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var runViewModel: RunViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init ViewModel dengan factory
        val factory = RunViewModelFactory(requireActivity().application)
        runViewModel = ViewModelProvider(requireActivity(), factory)[RunViewModel::class.java]

        // Tampilkan email user
        val user = (activity as MainActivity).user
        binding.tvUserName.text = "Halo, ${user?.email}!"

        // FAB navigasi ke AddRunFragment
        binding.fabAddRun.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addRunFragment)
        }

        // Setup adapter
        val runAdapter = RunAdapter(
            onEditClick = { run ->
                val bundle = Bundle().apply { putParcelable("run", run) }
                findNavController().navigate(R.id.action_homeFragment_to_editRunFragment, bundle)
            },
            onDeleteClick = { run ->
                runViewModel.deleteRun(run)
            }
        )

        binding.rvRuns.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRuns.adapter = runAdapter

        // Observe data dari Room
        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
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