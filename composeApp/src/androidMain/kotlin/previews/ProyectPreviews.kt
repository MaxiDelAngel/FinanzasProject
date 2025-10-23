package previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mdao.finanzasproject.App
import com.mdao.finanzasproject.data.ExpenseManager
import com.mdao.finanzasproject.model.Expense
import com.mdao.finanzasproject.model.ExpenseCategory
import com.mdao.finanzasproject.presentation.ExpensesUiState
import com.mdao.finanzasproject.ui.AllExpensesHeader
import com.mdao.finanzasproject.ui.ExpenseScreen
import com.mdao.finanzasproject.ui.ExpensesItem
import com.mdao.finanzasproject.ui.ExpensesTotalHeader
import com.mdao.finanzasproject.ui.OnboardingScreen

@Preview(showBackground = true)
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        ExpensesTotalHeader(total = 10.0)
    }
}

@Preview(showBackground = true)
@Composable
fun AllExpensesHeaderPreview() {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        AllExpensesHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun ExpensesItemPreview() {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        ExpensesItem(expense = ExpenseManager.fakeExpenseList[0], onExpenseClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ExpenseScreenPreview() {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        ExpenseScreen(
            uiState = ExpensesUiState(
                expenses = ExpenseManager.fakeExpenseList,
                total = 1052.2
            ), onExpenseClick = {})
    }
}

@Preview (showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    OnboardingScreen(onFinish = {})
}

@Preview (showBackground = true)
@Composable
fun AppScreenPreview(){
    App()
}