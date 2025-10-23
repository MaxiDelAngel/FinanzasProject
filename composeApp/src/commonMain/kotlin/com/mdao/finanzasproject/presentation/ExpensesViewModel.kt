package com.mdao.finanzasproject.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mdao.finanzasproject.domain.ExpenseRepository
import com.mdao.finanzasproject.model.Expense
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)

class ExpensesViewModel(private val repo: ExpenseRepository, function: () -> ExpensesViewModel) : ViewModel() {

    private val _uiState = MutableStateFlow(ExpensesUiState())
    val uiState = _uiState.asStateFlow()
    private val allExpense = repo.getAllExpenses()

    init {
        getAllExpenses()
    }

    private fun getAllExpenses() {
        viewModelScope.launch {
            updateState()
        }
    }

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            repo.addExpense(expense)
            updateState()
        }
    }

    fun editExpense(expense: Expense) {
        viewModelScope.launch {
            repo.editExpense(expense)
            updateState()
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            repo.deleteExpense(expense)
            updateState()
        }
    }

    private fun updateState() {
        _uiState.update { state ->
            state.copy(
                expenses = allExpense,
                total = allExpense.sumOf { it.amount }
            )
        }
    }

    fun getExpenseWithID(id: Long): Expense? {
        return allExpense.first { it.id == id }
    }

}