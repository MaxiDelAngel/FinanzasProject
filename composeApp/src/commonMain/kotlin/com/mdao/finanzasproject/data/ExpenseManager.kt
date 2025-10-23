package com.mdao.finanzasproject.data

import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    val fakeExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 100.0,
            category = ExpenseCategory.GROCERIES,
            description = "Weekly groceries"
        ),
        Expense(
            id = currentId++,
            amount = 50.0,
            category = ExpenseCategory.PARTY,
            description = "Dinner with friends"
        ),
        Expense(
            id = currentId++,
            amount = 10.2,
            category = ExpenseCategory.SNACKS,
            description = "Pizza"
        ),
        Expense(
            id = currentId++,
            amount = 5.0,
            category = ExpenseCategory.COFFEE,
            description = "Coffee"
        ),
        Expense(
            id = currentId++,
            amount = 21000.0,
            category = ExpenseCategory.CAR,
            description = "Audi A1"
        ),
        Expense(
            id = currentId++,
            amount = 25.0,
            category = ExpenseCategory.HOUSE,
            description = "Cleaning"
        ),
        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.OTHER,
            description = "Services"
        ),
    )

    fun AddNewExpense(expense: Expense){
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

    fun deleteExpense(expense: Expense){
        val index = fakeExpenseList.indexOfFirst { it.id == expense.id }
        fakeExpenseList.removeAt(index)
    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.GROCERIES,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.COFFEE,
            ExpenseCategory.CAR,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTHER,
        )
    }
}