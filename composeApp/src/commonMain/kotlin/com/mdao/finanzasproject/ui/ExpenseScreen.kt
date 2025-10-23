package com.mdao.finanzasproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mdao.finanzasproject.getColorsTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.mdao.finanzasproject.data.ExpenseManager
import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.presentation.ExpensesUiState

@Composable
fun ExpenseScreen(uiState: ExpensesUiState, onExpenseClick: (expense: Expense) -> Unit) {
    val colors = getColorsTheme()

    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Column(
                modifier = Modifier.background(colors.BackgroundColor)
            ) {
                ExpensesTotalHeader(uiState.total)
                AllExpensesHeader()
            }
        }
        items(uiState.expenses) { expense ->
            ExpensesItem(expense = expense, onExpenseClick = onExpenseClick)
        }
    }
}

@Composable
fun ExpensesTotalHeader(total: Double) {
    Card(
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(130.dp).padding(16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "$$total",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
            Text(modifier = Modifier.align(Alignment.CenterEnd), text = "USD", color = Color.Gray)
        }
    }
}

@Composable
fun AllExpensesHeader() {
    val colors = getColorsTheme()

    Row(
        modifier = Modifier.padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "All Expenses",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = colors.TextColor
        )
        Button(
            shape = RoundedCornerShape(50),
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray
            ),
            enabled = false
        ) {
            Text(text = "View All")
        }
    }
}

@Composable
fun ExpensesItem(expense: Expense, onExpenseClick: (expense: Expense) -> Unit) {
    val colors = getColorsTheme()

    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 2.dp)
            .clickable {
                onExpenseClick(expense)
            },
        colors = CardDefaults.cardColors(containerColor = colors.ColorExpenseItem),
        shape = RoundedCornerShape(30),
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = RoundedCornerShape(35),
                color = colors.Purple
            ) {
                Image(
                    modifier = Modifier.padding(10.dp),
                    imageVector = expense.icon,
                    contentDescription = "Imagen Icono Expense Item",
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier.padding(start = 8.dp).weight(1f)
            ) {
                Text(
                    text = expense.category.name,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    color = colors.TextColor
                )
                Text(
                    text = expense.description,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            Text(
                text = "$${expense.amount}",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colors.TextColor
            )
        }
    }
}