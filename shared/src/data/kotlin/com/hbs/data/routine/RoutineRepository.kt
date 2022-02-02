package com.hbs.data.routine

import com.hbs.data.Result
import com.hbs.domain.home.routine.Routine

class RoutineRepositoryImpl : RoutineRepository {
    override fun getRoutines(): Result<List<Routine>> {
        TODO("Not yet implemented")
    }
}

interface RoutineRepository {
    fun getRoutines() : Result<List<Routine>>
}