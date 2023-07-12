package com.example.todolist.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.LIGHTBLUE
import com.example.todolist.ui.theme.WHITE

@Composable
fun ButtonAdd(
    onClick: () -> Unit,
    modifier: Modifier,
    texto: String
){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColorFor(backgroundColor = LIGHTBLUE, )
        )
    ){
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}