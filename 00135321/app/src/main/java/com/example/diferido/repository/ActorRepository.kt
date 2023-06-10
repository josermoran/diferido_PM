package com.example.diferido.repository

import com.example.diferido.data.ActorModel.ActorModel

data class ActorRepository(private val actors : MutableList<ActorModel>){

    fun getActors() = actors

    fun addActor(actor : ActorModel) = actors.add(actor)
}
