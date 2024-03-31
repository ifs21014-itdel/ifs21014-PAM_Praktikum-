package com.ifs21014.pampraktikum8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.search.SearchBar
import com.google.android.material.search.SearchView
import com.ifs21014.pampraktikum8.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupSearchBar()

    }

    private fun setupRecyclerView() {
        val pengirim = resources.getStringArray(R.array.pengirim)
        val pesan = resources.getStringArray(R.array.pesan)
        val gambar = resources.getStringArray(R.array.gambar)
        val waktu = resources.getStringArray(R.array.waktu)

        val gmailList = mutableListOf<Gmail>()

        for (i in pengirim.indices) {
            gmailList.add(
                Gmail(
                    resources.getIdentifier(gambar[i], "drawable", requireContext().packageName),
                    pengirim[i],
                    waktu[i],
                    pesan[i]
                )
            )
        }

        val adapter = EmailAdapter(requireContext(), gmailList) { gmail ->
            val message = "Kamu membuka email dari: ${gmail.pengirim}"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }

        binding.rvGmail.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGmail.adapter = adapter
    }

    private fun setupSearchBar() {
        binding.svFragmentDashboard.setupWithSearchBar(binding.sbFragmentDashboard)
        binding.svFragmentDashboard.editText.setOnEditorActionListener { textView, actionId, event ->
            binding.sbFragmentDashboard.setText(binding.svFragmentDashboard.text)
            binding.svFragmentDashboard.hide()

            val message = "Kamu mencari dengan keywords:\n${binding.svFragmentDashboard.text}"
            Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
            false
        }
    }


}
