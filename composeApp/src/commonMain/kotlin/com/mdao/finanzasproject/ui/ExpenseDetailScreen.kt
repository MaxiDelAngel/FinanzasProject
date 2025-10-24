package com.mdao.finanzasproject.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.mdao.finanzasproject.getColorsTheme
import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.model.ExpenseCategory

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
    val keyboardController = LocalSoftwareKeyboardController.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(
        sheetState.targetValue
    ){
        if(sheetState.targetValue == SheetValue.Expanded){
            keyboardController?.hide()
        }
    }

    /*ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {

        }
    )*/
}

@Composable
private fun CategoryBottomSheetContent(
    categories: List<ExpenseCategory>,
    onCategorySelected: (ExpenseCategory) -> Unit
){
    LazyVerticalGrid(
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center
    ){
        items(categories){
            
        }
    }
}

@Composable
private fun CategoryItem(category: ExpenseCategory, onCategorySelected: (ExpenseCategory) -> Unit){

}