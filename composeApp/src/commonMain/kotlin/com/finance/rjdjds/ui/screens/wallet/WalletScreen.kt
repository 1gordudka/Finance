package com.finance.rjdjds.ui.screens.wallet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.data.db.Day
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.blue
import com.finance.rjdjds.ui.components.darkGrey
import com.finance.rjdjds.ui.components.grey
import com.finance.rjdjds.ui.components.lightBlue
import com.finance.rjdjds.ui.components.lightGrey
import com.finance.rjdjds.ui.components.noRippleClickable

@Composable
fun WalletScreen(
    balance: Int,
    history: List<Day>,
    income: () -> Unit,
    outcome: () -> Unit
) {


    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Wallet",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.height(35.dp))
        Text("Total Balance", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = lightGrey)
        Spacer(Modifier.height(10.dp))
        Text("\$$balance", fontSize = 48.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(20.dp))
        Row {
            Box(
                Modifier.weight(1f).clip(RoundedCornerShape(24.dp)).background(blue).padding(vertical = 25.dp).noRippleClickable { income() },
                contentAlignment = Alignment.Center
            ){
                Text("Income", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }
            Spacer(Modifier.width(16.dp))
            Box(
                Modifier.weight(1f).clip(RoundedCornerShape(24.dp)).background(bck).border(1.dp, Color.White, RoundedCornerShape(24.dp)).padding(vertical = 25.dp).noRippleClickable { outcome() },
                contentAlignment = Alignment.Center
            ){
                Text("Outcome", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
            }
        }
        Spacer(Modifier.height(30.dp))
        Row (Modifier.fillMaxWidth()){
            Text("Transactions", fontWeight = FontWeight.SemiBold, fontSize = 17.sp, color = Color.White)
        }
        Spacer(Modifier.height(15.dp))
        LazyColumn {
            items(history.reversed()){
                Row (
                    Modifier.padding(vertical = 8.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Box(
                        Modifier.size(40.dp).clip(CircleShape).background(darkGrey),
                        contentAlignment = Alignment.Center
                    ){
                        Text(if (it.isIncome) "+" else "-", fontSize = 24.sp, color = Color.White)
                    }
                    Spacer(Modifier.width(10.dp))
                    Column {
                        Text(if (it.isIncome) "Income" else "Outcome", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Medium)
                        Spacer(Modifier.height(4.dp))
                        Text(it.date, fontSize = 12.sp, color = lightGrey, fontWeight = FontWeight.Medium)
                    }
                    Spacer(Modifier.weight(1f))
                    Text("\$${it.amount}", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
                }
            }
        }
    }
}