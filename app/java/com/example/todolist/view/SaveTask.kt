package com.example.todolist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolist.components.ButtonAdd
import com.example.todolist.components.InputTextBox
import com.example.todolist.ui.theme.Purple700
import com.example.todolist.ui.theme.RADIO_GREEN_DISABLED
import com.example.todolist.ui.theme.RADIO_GREEN_ENABLED
import com.example.todolist.ui.theme.RADIO_RED_DISABLED
import com.example.todolist.ui.theme.RADIO_RED_ENABLED
import com.example.todolist.ui.theme.RADIO_YELLOW_DISABLED
import com.example.todolist.ui.theme.RADIO_YELLOW_ENABLED
import kotlin.reflect.KProperty

private operator fun Any.getValue(nothing: Nothing?, property: KProperty<*>) {

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SaveTask(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Salvar tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            )
        }
    )
    {
        var tituloTarefa by remember {
            mutableStateOf("")
        }
        var  descricaoTarefa by remember {
            mutableStateOf("")
        }
        var semPrioridade by remember {
            mutableStateOf(false)
        }
        var baixaPrioridade by remember {
            mutableStateOf(false)
        }
        var mediaPrioridade by remember {
            mutableStateOf(false)
        }
        var altaPrioridade by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            InputTextBox(
                value = tituloTarefa,
                onValueChange = {
                                tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Titulo tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )
            InputTextBox(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Descrição",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Nível de prioridade")

                RadioButton(selected = baixaPrioridade,
                    onClick = {
                        baixaPrioridade = !baixaPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_GREEN_DISABLED,
                        selectedColor = RADIO_GREEN_ENABLED
                    )
                )
                RadioButton(selected = mediaPrioridade,
                    onClick = {
                        mediaPrioridade = !mediaPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_YELLOW_DISABLED,
                        selectedColor = RADIO_YELLOW_ENABLED
                    )
                )
                RadioButton(selected = altaPrioridade,
                    onClick = {
                        altaPrioridade = !altaPrioridade
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_RED_DISABLED,
                        selectedColor = RADIO_RED_ENABLED
                    )
                )
            }
            ButtonAdd(onClick = {

            },
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                texto = "Salvar tarefa"
            )
        }
    }
}