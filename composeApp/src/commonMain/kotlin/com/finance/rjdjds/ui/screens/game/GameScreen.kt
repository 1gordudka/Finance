package com.finance.rjdjds.ui.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.blue
import com.finance.rjdjds.ui.components.darkGrey
import com.finance.rjdjds.ui.components.grey
import com.finance.rjdjds.ui.components.lightGrey
import com.finance.rjdjds.ui.components.secondColor
import kotlin.random.Random

@Composable
fun GameScreen() {

    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Finance Survival",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }

        FinancialSurvivalGame()

    }

}

@Composable
fun FinancialSurvivalGame() {
    var balance by remember { mutableStateOf(1000) }
    var day by remember { mutableStateOf(1) }
    var gameOver by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    val investments = remember { mutableStateMapOf("Stocks" to 0, "Crypto" to 0, "Real Estate" to 0) }
    val balanceHistory = remember { mutableStateListOf<Int>() }

    // Случайные события
    val randomEvent = listOf(
        "Market crash! All investments drop 20%" to { balance = (balance * 0.8).toInt() },
        "Tech boom! Stocks +25%" to { balance += (investments["Stocks"]!! * 0.25).toInt() },
        "Crypto rally! Crypto x2!" to { balance += investments["Crypto"]!! },
        "You found a wallet with $200!" to { balance += 200 },
        "Medical bill: -$150" to { balance -= 150 }
    )
    var currentEvent by remember { mutableStateOf<String?>(null) } // Текущее событие



    if (gameOver) {
        GameOverScreen(balance, day, balanceHistory) {
            balance = 1000
            day = 1
            gameOver = false
//            investments.values.clear()
            balanceHistory.clear()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Прогресс-бар дней
            LinearProgressIndicator(
                progress = day / 30f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(lightGrey, RoundedCornerShape(4.dp)),
                color = blue,
                backgroundColor = lightGrey,
                strokeCap = StrokeCap.Round
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Day $day / 30", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Text("Balance: $$balance", fontSize = 24.sp, color = blue)

            // График баланса
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(secondColor, RoundedCornerShape(16.dp))
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    balanceHistory.forEach { value ->
                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                                .height((value / 20).dp)
                                .background(blue, RoundedCornerShape(4.dp))
                                .padding(end = 2.dp)
                        )
                    }
                }
            }

            // Случайное событие
            Spacer(modifier = Modifier.height(16.dp))
            if (day > 1) {
                var eventText by remember { mutableStateOf("") }
                LaunchedEffect(day) {
                    if (day > 1) {
                        eventText = randomEvent.random().first
                        val eventAction = randomEvent.random().second
                        currentEvent = eventText
                        eventAction.invoke()
                    } else {
                        currentEvent = null
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = grey
                ) {
                    Text(
                        text = "Event: $eventText",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            // Кнопки действий
            Spacer(modifier = Modifier.height(24.dp))
            ActionButton("Invest in Stocks (High risk)") {
                val amount = Random.nextInt(100, 300)
                balance -= amount
                investments["Stocks"] = investments["Stocks"]!! + amount
                message = "Invested $amount in stocks"
            }
            ActionButton("Buy Crypto (Extreme risk)") {
                val amount = Random.nextInt(50, 150)
                balance -= amount
                investments["Crypto"] = investments["Crypto"]!! + amount
                message = "Bought $amount crypto"
            }
            ActionButton("Work (Safe +$200)") {
                balance += 200
                message = "You earned $200"
            }

            // Переход к следующему дню
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    balanceHistory.add(balance)
                    day++
                    if (balance >= 5000 || day > 30) gameOver = true
                    if (balance <= 0) {
                        gameOver = true
                        message = "Bankrupt!"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = blue)
            ) {
                Text("Next Day →", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = grey)
    ) {
        Text(text, color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun GameOverScreen(balance: Int, day: Int, history: List<Int>, onRestart: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = if (balance >= 5000) "🏆 You're a Millionaire!" else "💸 Game Over!",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = if (balance >= 5000) blue else Color.Red
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text("Final balance: $$balance", fontSize = 24.sp, color = Color.White)
        Text("Days survived: $day", fontSize = 20.sp, color = lightGrey)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onRestart,
            modifier = Modifier
                .width(200.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = blue)
        ) {
            Text("Play Again", fontSize = 18.sp, color = Color.White)
        }
    }
}
