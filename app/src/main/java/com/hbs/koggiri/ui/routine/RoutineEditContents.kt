package com.hbs.koggiri.ui.routine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hbs.koggiri.R
import com.hbs.koggiri.models.SelectionRoutinePresentation
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.component.KoggiriSmallText
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.home.component.SelectionRoutineList
import com.hbs.koggiri.ui.theme.NeutralVariant95

@Composable
fun RoutineEditContents(
    title: String,
    subtitle: String
) {
    val selectionRoutines = listOf(
        SelectionRoutinePresentation("Lose Weight", R.drawable.weight_lifting),
        SelectionRoutinePresentation("Build Muscle", R.drawable.metabolism),
        SelectionRoutinePresentation("Increase Energy", R.drawable.continuous),
        SelectionRoutinePresentation("Yoga", R.drawable.yoga),
        SelectionRoutinePresentation("Bike", R.drawable.bike),
        SelectionRoutinePresentation("Supplements", R.drawable.supplements)
    )

    Box(
        Modifier
            .fillMaxSize()
            .background(NeutralVariant95)
    ) {
        Column(Modifier.getCardModifier()) {
            KoggiriMediumTitle(title = title, height = 32.dp)
            KoggiriSmallText(title = subtitle, color = Color.LightGray)
            Spacer(Modifier.height(16.dp))
            SelectionRoutineList(selectionRoutines)
        }
    }

}