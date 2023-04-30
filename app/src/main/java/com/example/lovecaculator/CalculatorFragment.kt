package com.example.lovecaculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.LoveViewModel
import com.example.lovecaculator.databinding.FragmentCalculatorBinding
import com.example.remote.LoveModel
import com.example.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding

    val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.liveLove(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner) { loveModel ->
                        Log.e("kalbusha", "initClickers: ${loveModel}")
                    }
            }
        }
    }
}