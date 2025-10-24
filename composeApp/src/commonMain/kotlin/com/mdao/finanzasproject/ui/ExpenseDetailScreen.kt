package com.mdao.finanzasproject.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.mdao.finanzasproject.getColorsTheme
import com.mdao.finanzasproject.model.Expense

@ExperimentalMaterial3Api
@Composable
fun ExpenseDetailScreen(
    expenseToEdit: Expense? = null,
    addExpenseAndNavigateBack: (Expense) -> Unit
){
    val colors = getColorsTheme()
    var price by remember { mutableStateOf(expenseToEdit?.amount ?: 0.0) }
    var description by remember { mutableStateOf(expenseToEdit?.description ?: "") }
    var expenseCategory by remember { mutableStateOf(expenseToEdit?.category?.name ?: "") }
    var categorySelected by remember { mutableStateOf(expenseToEdit?.category?.name ?: "Select a category") }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { true }
    )
}