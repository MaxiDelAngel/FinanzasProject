package com.mdao.finanzasproject.domain

import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.model.ExpenseCategory

interface ExpenseRepository {
    fun getAllExpenses(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
    fun deleteExpense(expense: Expense): List<Expense>
}