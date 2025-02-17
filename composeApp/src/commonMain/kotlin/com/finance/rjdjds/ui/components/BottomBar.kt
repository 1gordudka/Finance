package com.finance.rjdjds.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.ui.QUIZ
import com.finance.rjdjds.ui.SETTINGS
import com.finance.rjdjds.ui.TIPS
import com.finance.rjdjds.ui.WALLET
import finance.composeapp.generated.resources.Res
import finance.composeapp.generated.resources.quiz
import finance.composeapp.generated.resources.settings
import finance.composeapp.generated.resources.tips
import finance.composeapp.generated.resources.wallet
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.vectorResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BottomBar(
    screen: String,
    change: (String) -> Unit
) {

    val screens = listOf(
        Pair(Res.drawable.wallet, WALLET),
        Pair(Res.drawable.quiz, QUIZ),
        Pair(Res.drawable.settings, SETTINGS),
        Pair(Res.drawable.tips, TIPS)
    )


    Column(
        modifier = Modifier.fillMaxWidth().background(bck).navigationBarsPadding()
    ) {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 0.5.dp,
            color = Color.White.copy(alpha = 0.5f)
        )
        Row (
            Modifier.fillMaxWidth().padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){

            screens.forEach {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.noRippleClickable {
                        change(it.second)
                    }
                ) {
                    Icon(vectorResource(it.first), "",
                        modifier = Modifier.size(20.dp), tint = if (screen == it.second) Color.White else grey)
                    Spacer(Modifier.height(4.dp))
                    Text(it.second, color = if (screen == it.second) Color.White else grey, fontSize = 10.sp, fontWeight = FontWeight.Medium)
                }
            }

        }
    }
}