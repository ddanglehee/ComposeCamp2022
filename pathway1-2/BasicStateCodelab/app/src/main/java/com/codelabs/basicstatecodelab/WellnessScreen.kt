package com.codelabs.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        StatefulCounter(modifier)

        val taskList = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(taskList, onCloseTask = { task -> taskList.remove(task) })
    }
}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task #$i")
}