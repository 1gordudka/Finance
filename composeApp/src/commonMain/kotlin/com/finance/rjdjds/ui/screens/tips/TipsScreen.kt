package com.finance.rjdjds.ui.screens.tips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.data.local.Tip
import com.finance.rjdjds.data.local.tips
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.noRippleClickable
import com.finance.rjdjds.ui.components.secondColor

@Composable
fun TipsScreen(
    goToTip: (Int) -> Unit
) {

    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Financial tips",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.height(20.dp))
        LazyColumn {
            items(tips){
                TipCard(it, {
                    goToTip(tips.indexOf(it))
                })
            }
        }
    }

}

@Composable
fun TipCard(
    tip: Tip,
    click: () -> Unit
) {

    Column(
        Modifier.padding(vertical = 12.dp).clip(RoundedCornerShape(16.dp)).background(secondColor).padding(16.dp).noRippleClickable { click() }
    ) {
        Text(tip.name, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(10.dp))
        Text(tip.description, fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Medium, maxLines = 4)
    }
}