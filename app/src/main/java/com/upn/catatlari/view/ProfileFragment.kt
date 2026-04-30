package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.catatlari.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tampilkan data user dari MainActivity
        val user = (activity as MainActivity).user
        binding.tvUserName.text = user?.email ?: "Pengguna"
        binding.tvUserEmail.text = user?.email ?: "-"

        // Tombol edit profile - tidak berfungsi (sesuai requirement)
        binding.buttonEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Fitur segera hadir!", Toast.LENGTH_SHORT).show()
        }

        // Tombol logout - kembali ke AuthActivity
        binding.buttonLogout.setOnClickListener {
            requireActivity().finish()
        }
    }
}