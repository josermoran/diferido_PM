package com.example.diferido.ui.actores.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.diferido.ActorReviewerApplication
import com.example.diferido.data.ActorModel.ActorModel
import com.example.diferido.repository.ActorRepository

data class ActorViewModel(private val repository: ActorRepository) : ViewModel(){
    //Live Data
    var name = MutableLiveData("")
    var age = MutableLiveData("")
    var description = MutableLiveData("")
    var status = MutableLiveData("")

    fun getActors() = repository.getActors()

    private fun addActor (actor: ActorModel) = repository.addActor(actor)

    fun createActor() {
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val actor = ActorModel(
            name.value!!,
            age.value!!,
            description.value!!
        )

        addActor(actor)
        clearData()

        status.value = ACTOR_CREATED
    }

    private fun validateData() : Boolean{
        when {
            name.value.isNullOrEmpty() -> return false
            age.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
        }
        return true
    }

    private fun clearData() {
        name.value = ""
        age.value = ""
        description.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as ActorReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}
