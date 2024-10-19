package com.example.testshiftlaba2024.editNote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.testshiftlaba2024.databinding.FragmentEditNoteBinding


class EditNoteFragment : Fragment() {
    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.saveButton.setOnClickListener {
            val action = EditNoteFragmentDirections
                .actionEditNoteFragmentToNotesFragment()
            view.findNavController().navigate(action)
        }

        binding.deleteButton.setOnClickListener {
            val action = EditNoteFragmentDirections
                .actionEditNoteFragmentToNotesFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}