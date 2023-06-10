package com.example.diferido.repository

import com.example.diferido.data.ActorModel.ActorModel

data class ActorRepository(private val actor : MutableList<ActorModel>){

    fun getActors() = actor

    fun addActor(actor : ActorModel) = actor.add(actor)
}
