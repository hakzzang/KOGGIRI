package com.hbs.koggiri.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.models.RoutinePresentation
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.home.state.HomeUiState

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onClickRoutineContent: (RoutinePresentation) -> Unit,
    onClickSaladHistoryContent: () -> Unit,
    onClickGreetingContent: (String) -> Unit,
    onClickGreetingEdit: (String) -> Unit
) {
    val saladHistories = listOf(
        "2022년 1월 1일",
        "2022년 1월 2일",
        "2022년 1월 3일",
        "2022년 1월 4일",
        "2022년 1월 5일",
        "2022년 1월 6일"
    )

    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        GreetingContent(
            onClickGreetingContent = onClickGreetingContent,
            onClickGreetingEdit = onClickGreetingEdit,
            modifier = Modifier.getCardModifier()
        )
        RoutineContent(
            title = "Your routine",
            uiState = uiState,
            onClickRoutineContent = onClickRoutineContent,
            modifier = Modifier.getCardModifier()
        )
        SaladHistoryList(
            saladHistories = saladHistories,
            modifier = Modifier.getCardModifier()
        )
        GalleryHistoryList(
            saladHistories = saladHistories,
            modifier = Modifier.getCardModifier()
        )
        Spacer(Modifier.height(72.dp))
    }
}

