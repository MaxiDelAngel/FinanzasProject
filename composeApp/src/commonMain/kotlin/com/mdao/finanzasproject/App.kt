@file:OptIn(ExperimentalMaterial3Api::class)

package com.mdao.finanzasproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdao.finanzasproject.data.TitleTopBarTypes
import com.mdao.finanzasproject.navigation.NavigationWrapper
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val colors = getColorsTheme()

    PreComposeApp {
        AppTheme {
            val navigator = rememberNavigator()
            val currentEntry = navigator.currentEntry.collectAsState(null).value
            val currentRoute = currentEntry?.route?.route
            val isOnboardingScreen = currentRoute == "/onboarding"
            val titleTopBar = getTitleTopAppBar(navigator)
            val isEditOrAddExpenses = titleTopBar != TitleTopBarTypes.DASHBOARD.value
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    if (!isOnboardingScreen) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = titleTopBar,
                                    fontSize = 25.sp,
                                    color = colors.TextColor
                                )
                            },
                            navigationIcon = {
                                if (isEditOrAddExpenses) {
                                    IconButton(
                                        onClick = {
                                            navigator.popBackStack()
                                        }
                                    ) {
                                        Icon(
                                            modifier = Modifier.padding(start = 16.dp),
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            tint = colors.TextColor,
                                            contentDescription = "Back arrow icon"
                                        )
                                    }
                                } else {
                                    Icon(
                                        modifier = Modifier.padding(start = 16.dp),
                                        imageVector = Icons.Default.Apps,
                                        tint = colors.TextColor,
                                        contentDescription = "Dashboard icon"
                                    )
                                }
                            }
                        )
                    }
                },
                floatingActionButton = {
                    if (!isEditOrAddExpenses && !isOnboardingScreen) {
                        FloatingActionButton(
                            modifier = Modifier.padding(8.dp),
                            onClick = {
                                navigator.navigate("/addExpenses")
                            },
                            shape = RoundedCornerShape(50),
                            containerColor = colors.AddIconColor,
                            contentColor = Color.White,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                tint = Color.White,
                                contentDescription = "Add Floating icon"
                            )
                        }
                    }
                }

            ) { innerPadding ->
                NavigationWrapper(navigator, innerPadding)
            }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    var titleTopBar = TitleTopBarTypes.DASHBOARD

    val isOnAddExpenses =
        navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpenses/{id}?")
    if (isOnAddExpenses) {
        titleTopBar = TitleTopBarTypes.ADD_EXPENSE
    }

    val isOnEditExpense = navigator.currentEntry.collectAsState(null).value?.path<Long>("id")
    isOnEditExpense?.let {
        titleTopBar = TitleTopBarTypes.EDIT
    }

    return titleTopBar.value
}