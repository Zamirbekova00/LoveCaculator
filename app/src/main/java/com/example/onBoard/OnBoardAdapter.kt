package com.example.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecaculator.R
import com.example.lovecaculator.databinding.ItemOnBoardBinding

class OnBoardAdapter(private val onStartClick: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            "Have a good time",
            "You should take the \n time to help those who need you",
            R.raw.love1
        ),
        OnBoard(
            "Cherishing love",
            "It is now no longer possible \n for you to cherish love",
            R.raw.love2
        ),
        OnBoard(
            "Have a break up?",
            "We have made the correction for you don't worry.\n Maybe someone is waiting for you",
            R.raw.love3
        ),
        OnBoard(
            "It's Funs and Many more", "",
            R.raw.love4
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnBoardBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.apply {
                lottieLove.setAnimation(onBoard.lottie)
                title.text = onBoard.title
                desc.text = onBoard.desc
            }
            binding.btnGetStarted.isVisible = adapterPosition == data.lastIndex
            binding.btnGetStarted.setOnClickListener {
                onStartClick()
            }
        }
    }
}