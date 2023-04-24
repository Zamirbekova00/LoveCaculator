package com.example.lovecaculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecaculator.databinding.FragmentCalculatorBinding
import retrofit2.Call
import retrofit2.Response

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                RetrofitService().api.percentageNames(
                    etMe.text.toString(), etYou.text.toString()
                ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            Log.e("kalbusha", "onResponse: ${response.body()}")
                            findNavController().navigate(
                                R.id.resultFragment, bundleOf("result" to response.body())
                            )
                            etMe.text.clear()
                            etYou.text.clear()
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("kalbusha", "onFailure:${t.message} ")
                    }
                })
            }
        }
    }
}