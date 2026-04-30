package com.upn.catatlari.view

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentEditRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel
import com.upn.catatlari.viewmodel.RunViewModelFactory
import java.util.Calendar

class EditRunFragment : Fragment() {

    private lateinit var binding: FragmentEditRunBinding
    private lateinit var runViewModel: RunViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEditRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = RunViewModelFactory(requireActivity().application)
        runViewModel = ViewModelProvider(requireActivity(), factory)[RunViewModel::class.java]

        val run: Run? = arguments?.getParcelable<Run>("run")

        run?.let {
            binding.etDate.setText(it.runDate)
            binding.etDistance.setText(it.runDistance.toString())
            binding.etDuration.setText(it.runDuration.toString())
        }

        binding.etDate.setOnClickListener {
            showDatePicker { selectedDate -> binding.etDate.setText(selectedDate) }
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonUpdate.setOnClickListener {
            val runDate = binding.etDate.text.toString().trim()
            val runDistance = binding.etDistance.text.toString().trim()
            val runDuration = binding.etDuration.text.toString().trim()

            if (runDate.isEmpty() || runDistance.isEmpty() || runDuration.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            run?.let {
                runViewModel.updateRun(
                    Run(
                        id = it.id,
                        runDate = runDate,
                        runDistance = runDistance.toIntOrNull() ?: 0,
                        runDuration = runDuration.toIntOrNull() ?: 0
                    )
                )
            }
            findNavController().popBackStack()
        }
    }

    private fun showDatePicker(onDateSelected: (String) -> Unit) {
        val cal = Calendar.getInstance()
        DatePickerDialog(requireContext(), { _, y, m, d ->
            onDateSelected("%02d-%02d-%04d".format(d, m + 1, y))
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
    }
}