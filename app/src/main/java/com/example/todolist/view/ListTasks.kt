@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.todolist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolist.R
import com.example.todolist.listItem.TaskItem
import com.example.todolist.model.Task
import com.example.todolist.ui.theme.BLACK
import com.example.todolist.ui.theme.Purple700
import com.example.todolist.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListTasks(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Purple700),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = WHITE
                    )
                }
            )
        },
        containerColor = BLACK,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("saveTask")
                },
                containerColor = Purple700
            ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Ícone de salvar tarefa")
            }
        }
    ) {

        val listTasks: MutableList<Task> = mutableListOf(
            Task(
                task = "Jogar videogame",
                description = "jaklfj;ajf",
                priority = 0
            ),
            Task(
                task = "Programar o app mobile",
                description = "jaklfj;ajf",
                priority = 1
            ),
            Task(
                task = "Teste",
                description = "jaklfj;ajf",
                priority = 2
            )
        )
        LazyColumn{
            itemsIndexed(listTasks) {
                position, _-> TaskItem(position, listTasks)
            }
        }
    }
}