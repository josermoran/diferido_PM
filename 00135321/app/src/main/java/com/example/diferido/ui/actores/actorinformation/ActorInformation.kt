package com.example.diferido.ui.actores.actorinformation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diferido.R
import com.example.diferido.databinding.FragmentNewActorBinding

class ActorInformation : Fragment() {

    private lateinit var binding : FragmentNewActorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewActorBinding.inflate(inflater, container, false)
        return binding.root
    }
}

