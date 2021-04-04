package com.megatrust.jobsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.megatrust.jobsapp.R
import com.megatrust.jobsapp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private val adapter = JobsAdapter(::onJobClicked)

    private fun onJobClicked(job: Job) {
        // do whatever u need when the job item clicked
        Toast.makeText(requireContext(), job.title, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.stateLiveData.observe(viewLifecycleOwner, { state ->
            renderState(state)
        })
    }

    private fun initViews() {
        binding.jobsRv.adapter = adapter
    }

    private fun renderState(state: HomeState) {
        when (state) {
            is HomeState.Error -> showError(state.errorMessage)
            HomeState.Loading -> showLoading()
            is HomeState.Success -> showSuccess(state)
        }
    }

    private fun showError(errorMessage: String) {
        // handel error state
    }

    private fun showLoading() {
        binding.loadingPb.visibility = View.VISIBLE
        binding.jobsRv.visibility = View.GONE
    }

    private fun showSuccess(state: HomeState.Success) {
        adapter.submitList(state.jobsList)
        binding.loadingPb.visibility = View.GONE
        binding.jobsRv.visibility = View.VISIBLE
    }


    // view binding ( till create ViewBindingDelegate )
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}