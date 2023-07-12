package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.view.ListTasks
import com.example.todolist.view.SaveTask

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listTasks") {
                    composable(
                        route = "listTasks"
                    ){
                        ListTasks(navController)
                    }

                    composable(
                        route = "saveTask"
                    ) {
                        SaveTask(navController)
                    }
                }

            }
        }
    }
}