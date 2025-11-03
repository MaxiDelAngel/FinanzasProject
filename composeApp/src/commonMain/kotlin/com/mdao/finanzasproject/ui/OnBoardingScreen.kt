package com.mdao.finanzasproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mdao.finanzasproject.getColorsTheme
import finanzasproject.composeapp.generated.resources.Res
import finanzasproject.composeapp.generated.resources.img1
import finanzasproject.composeapp.generated.resources.img2
import finanzasproject.composeapp.generated.resources.img3
import org.jetbrains.compose.resources.painterResource

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val colors = getColorsTheme()

    val pages = listOf(
        "Controla tus finanzas" to "Registra tus gastos e ingresos de manera simple y visual.",
        "Alcanza tus metas" to "Define objetivos financieros y sigue tu progreso cada día.",
        "Tu dinero, bajo control" to "Empieza ahora y transforma tu relación con el dinero."
    )

    val imagenes = listOf(
        painterResource(Res.drawable.img1),
        painterResource(Res.drawable.img2),
        painterResource(Res.drawable.img3)
    )

    var currentPage by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = imagenes[currentPage],
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(1f)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = pages[currentPage].first,
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = pages[currentPage].second,
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        ) {
            repeat(pages.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (index == currentPage) 12.dp else 8.dp)
                        .background(
                            if (index == currentPage) colors.Purple else Color.LightGray,
                            shape = CircleShape
                        )
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (currentPage > 0) {
                TextButton(onClick = { currentPage-- }) {
                    Text("Atrás")
                }
            }

            Button(onClick = {
                if (currentPage < pages.lastIndex) {
                    currentPage++
                } else {
                    onFinish()
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.Purple,
                    contentColor = Color.White
                )
            ) {
                Text(if (currentPage == pages.lastIndex) "Comenzar" else "Siguiente")
            }
        }
    }
}