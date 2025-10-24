package com.mdao.finanzasproject.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import com.mdao.finanzasproject.data.ExpenseManager
import com.mdao.finanzasproject.data.ExpenseRepoImplement
import com.mdao.finanzasproject.getColorsTheme
import com.mdao.finanzasproject.presentation.ExpensesViewModel
import com.mdao.finanzasproject.ui.ExpenseDetailScreen
import com.mdao.finanzasproject.ui.ExpenseScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path


@Composable
fun NavigationWrapper(navigator: Navigator, innerPadding: PaddingValues){
    val colors = getColorsTheme()

    val viewModel = ExpensesViewModel(ExpenseRepoImplement(ExpenseManager)){
        ExpensesViewModel(ExpenseRepoImplement(ExpenseManager), function = TODO())
    }

    NavHost(
        modifier = Modifier.background(colors.BackgroundColor).padding(innerPadding),
        navigator = navigator,
        initialRoute = "/home"
    ){
        scene(route = "/home") {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpenseScreen(uiState) { expense ->
                navigator.navigate("/addExpenses/${expense.id}")
            }
        }

        scene(route = "/addExpenses/{id}?") { backStackEntry ->
            val idFromPath = backStackEntry.path<Long>("id")
            val expenseToEditOrAdd = idFromPath?.let { id -> viewModel.getExpenseWithID(id) }

            ExpenseDetailScreen(expenseToEdit = expenseToEditOrAdd){ expense   ->
                if(expenseToEditOrAdd == null) {
                    viewModel.addExpense(expense)
                } else {
                    viewModel.editExpense(expense)
                }
                navigator.popBackStack()
            }
        }
    }
}