package com.example.lovecaculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.App
import com.example.lovecaculator.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list = App.appDatabase.getDao().getAll() as ArrayList
        list.forEach {
            var result =
                "${it.firstName}\n ${it.secondName}\n ${it.percentage}\n ${it.result}\n\n\n\n"
            binding.tvHistory.append(result)
        }
    }
}