package com.example.diferido

import android.app.Application
import com.example.diferido.data.ActorModel.ActorModel
import com.example.diferido.data.actor
import com.example.diferido.repository.ActorRepository

class ActorReviewerApplication : Application() {
        val actorRepository : ActorRepository by lazy {
            ActorRepository(actor)
        }
}