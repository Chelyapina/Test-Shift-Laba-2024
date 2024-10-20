package com.example.testshiftlaba2024.createNote

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.testshiftlaba2024.NoteRepository
import com.example.testshiftlaba2024.R
import com.example.testshiftlaba2024.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {
    private var _binding: FragmentCreateNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val repository = NoteRepository.getInstance(application)
        val viewModelFactory = CreateNoteViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CreateNoteViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        viewModel.navigateToNotesList.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(requireView().windowToken, 0)
                view.findNavController()
                    .navigate(R.id.action_createNoteFragment_to_notesFragment)
                viewModel.onNavigateToNotesList()
            }
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}