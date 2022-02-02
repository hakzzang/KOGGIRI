package com.hbs.data.routine

import com.hbs.data.Result
import com.hbs.domain.home.routine.Routine

class RoutineRepositoryImpl : RoutineRepository {
    override fun getRoutines(): Result<List<Routine>> {
        val routines = listOf(
            Routine("Days Running", "하루 아침마다 런닝 뛰기", emptyList()),
            Routine("Days Eating Salad", "매일 샐러드 먹기", emptyList()),
            Routine("Days Watching Calmdown Man", "매일 침투브 보기", emptyList())
        )

        return Result.Success(routines)
    }
}

interface RoutineRepository {
    fun getRoutines(): Result<List<Routine>>
}