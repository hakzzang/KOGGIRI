package com.hbs.koggiri.ui.routine

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hbs.koggiri.R
import com.hbs.koggiri.models.SelectionRoutinePresentation
import com.hbs.koggiri.ui.component.KoggiriMediumTitle
import com.hbs.koggiri.ui.component.KoggiriSmallText
import com.hbs.koggiri.ui.component.getCardModifier
import com.hbs.koggiri.ui.home.component.SelectionRoutineList
import com.hbs.koggiri.ui.home.state.HomeUiState
import com.hbs.koggiri.ui.theme.NeutralVariant95
import com.hbs.koggiri.ui.theme.PointBlueColor

@Preview
@Composable
fun ProvideSelectionRoutineContents() {
    SelectionRoutineContents(
        title = "What are you goals?",
        subtitle = "Select all that apply",
        onClickEditDoneButton = { }
    )
}

@Preview
@Composable
fun ProvideCounterRoutineContents() {
    CounterRoutineContents(
        title = "What are you goals?",
        subtitle = "Select all that apply",
        onClickEditDoneButton = {

        }
    )
}

@Composable
fun SelectionRoutineContents(
    title: String,
    subtitle: String,
    onClickEditDoneButton: ((Int) -> Unit)
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
        Column(
            Modifier
                .getCardModifier()
                .fillMaxHeight(0.95f)
        ) {
            KoggiriMediumTitle(title = title, height = 32.dp)
            KoggiriSmallText(title = subtitle, color = Color.LightGray)
            Spacer(Modifier.height(16.dp))
            SelectionRoutineList(selectionRoutines)
            Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
                FilledTonalButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { onClickEditDoneButton(1) }) {
                    Text("Continue")
                }
            }
        }
    }
}

@Composable
fun CounterRoutineContents(
    uiState: HomeUiState.EditScreenUiState? = null,
    title: String,
    subtitle: String,
    onClickEditDoneButton: ((Int) -> Unit)
) {
    val total = 4
    var text by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .background(NeutralVariant95)
    ) {
        Column(
            Modifier
                .getCardModifier()
                .fillMaxHeight(0.95f)
        ) {
            KoggiriMediumTitle(title = title, height = 32.dp)
            KoggiriSmallText(title = subtitle, color = Color.LightGray)
            Spacer(Modifier.height(16.dp))
            KoggiriSmallText(title = "Step ${uiState?.step} of $total", color = Color.Black)
            Spacer(Modifier.height(24.dp))
            TextField(
                value = text,
                onValueChange = { input -> text = input },
                placeholder = {
                    androidx.compose.material.Text(
                        text = "Enter your goal",
                        color = Color.LightGray
                    )
                },
                trailingIcon = {
                    Card(
                        shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp),
                        backgroundColor = PointBlueColor
                    ) {
                        Text(
                            text = "EA",
                            style = MaterialTheme.typography.caption.copy(
                                fontSize = 10.sp,
                                letterSpacing = 0.2.sp
                            ),
                            modifier = Modifier.padding(horizontal = 5.dp, vertical = 2.dp),
                            color = Color.White
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color(0xFFF1F3F5))
            )
            Box(Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomCenter) {
                FilledTonalButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { onClickEditDoneButton(1) },
                    colors = ButtonDefaults.filledTonalButtonColors()) {
                    Text("Continue")
                }
            }
        }
    }
}