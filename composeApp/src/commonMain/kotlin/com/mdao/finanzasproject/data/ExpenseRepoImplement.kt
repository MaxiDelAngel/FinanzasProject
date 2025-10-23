package com.mdao.finanzasproject.data

import com.mdao.finanzasproject.domain.ExpenseRepository
import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.model.ExpenseCategory

class ExpenseRepoImplement(private val expenseManager: ExpenseManager): ExpenseRepository {
    override fun getAllExpenses(): List<Expense> {
        return expenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        expenseManager.AddNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        expenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return expenseManager.getCategories()
    }

    override fun deleteExpense(expense: Expense): List<Expense> {
        expenseManager.deleteExpense(expense)
        return expenseManager.fakeExpenseList
    }
}