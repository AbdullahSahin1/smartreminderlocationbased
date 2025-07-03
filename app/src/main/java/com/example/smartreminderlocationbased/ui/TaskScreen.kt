package com.example.smartreminderlocationbased.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

@Composable
fun TaskScreen() {
    var taskText by remember { mutableStateOf("") }
    var locationText by remember { mutableStateOf("") }
    val taskList = remember { mutableStateListOf<Pair<String, String>>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Görev Ekle", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = taskText,
            onValueChange = { taskText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(56.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (taskText.isEmpty()) Text("Görev açıklaması girin...")
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = locationText,
            onValueChange = { locationText = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .height(56.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (locationText.isEmpty()) Text("Konum adı girin...")
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (taskText.isNotBlank() && locationText.isNotBlank()) {
                    taskList.add(taskText to locationText)
                    taskText = ""
                    locationText = ""
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Ekle")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Görevler", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(taskList.size) { index ->
                val (task, location) = taskList[index]
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(2.dp)
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(text = task, style = MaterialTheme.typography.bodyLarge)
                        Text(text = location, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
} 