package com.example.testshiftlaba2024.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.testshiftlaba2024.domain.NoteRepository
import com.example.testshiftlaba2024.presentation.noteItem.NoteItemAdapter
import com.example.testshiftlaba2024.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val repository = NoteRepository.getInstance(application)
        val viewModelFactory = NotesViewModelFactory(repository)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(NotesViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = NoteItemAdapter { noteId ->
            viewModel.onNoteClicked(noteId)
        }
        binding.notesList.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        viewModel.navigateToNoteEditor.observe(viewLifecycleOwner, Observer { noteId ->
            noteId?.let {
                val action = NotesFragmentDirections
                    .actionNotesFragmentToEditNoteFragment(noteId)
                this.findNavController().navigate(action)
                viewModel.onNoteNavigated()
            }
        })

        binding.fab.setOnClickListener {
            val action = NotesFragmentDirections
                .actionNotesFragmentToCreateNoteFragment()
            view.findNavController().navigate(action)
        }

        viewModel.notesCountLiveData.observe(viewLifecycleOwner) { count ->
            binding.notesList.visibility = if (count > 0) View.VISIBLE else View.GONE
            binding.emptyTextView.visibility = if (count > 0) View.GONE else View.VISIBLE
        }

        viewModel.notesCountLiveData.observe(viewLifecycleOwner) { count ->
            binding.notesList.visibility = if (count > 0) View.VISIBLE else View.GONE
            binding.emptyTextView.visibility = if (count > 0) View.GONE else View.VISIBLE
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}