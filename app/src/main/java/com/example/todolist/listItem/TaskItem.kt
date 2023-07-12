package com.example.todolist.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.todolist.R
import com.example.todolist.model.Task
import com.example.todolist.ui.theme.RADIO_GREEN_ENABLED
import com.example.todolist.ui.theme.RADIO_RED_ENABLED
import com.example.todolist.ui.theme.RADIO_YELLOW_ENABLED
import com.example.todolist.ui.theme.WHITE

@Composable
fun TaskItem(
    position: Int,
    listTasks: MutableList<Task>
) {

    val titleTask = listTasks[position].task
    val descriptionTask = listTasks[position].description
    val priority = listTasks[position].priority

    var priorityLevel: String = when (priority) {
        0 -> {
            "Sem prioridade"
        }

        1 -> {
            "Prioridade baixa"
        }

        2 -> {
            "Prioridade média"
        }

        else -> {
            "Prioridade alta"
        }
    }

    val color = when (priority) {
        0 -> {
            Color.Black
        }

        1 -> {
            RADIO_GREEN_ENABLED
        }

        2 -> {
            RADIO_YELLOW_ENABLED
        }

        else -> {
            RADIO_RED_ENABLED
        }
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = WHITE
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(60.dp)
        ) {
            val (txtTitle, txtDescription, cardPriority, txtPriority, btnDelete) = createRefs()

            Text(
                text = titleTask.toString(),
                modifier = Modifier.constrainAs(txtTitle) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = descriptionTask.toString(),
                modifier = Modifier.constrainAs(txtDescription) {
                    top.linkTo(txtTitle.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )
            Text(
                text = priorityLevel,
                modifier = Modifier.constrainAs (txtPriority) {
                    top.linkTo(txtDescription.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = color
                ),
                modifier = Modifier
                    .size(20.dp)
                    .constrainAs(cardPriority) {
                        top.linkTo(txtDescription.bottom, margin = 10.dp)
                        start.linkTo(txtPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = RoundedCornerShape(100.dp)
            ) {

            }

            IconButton(
                onClick = {

                },
                modifier = Modifier.constrainAs(btnDelete) {
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(cardPriority.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.delete_icon),
                    contentDescription = null
                )
            }
        }

    }
}