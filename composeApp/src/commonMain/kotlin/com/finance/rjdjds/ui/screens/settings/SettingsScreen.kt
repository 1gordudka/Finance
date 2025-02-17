package com.finance.rjdjds.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.lightBlue
import com.finance.rjdjds.ui.components.noRippleClickable
import com.finance.rjdjds.ui.components.secondColor

@Composable
fun SettingsScreen(
    privacy: () -> Unit,
    terms: () -> Unit
) {

    var isNot by remember{
        mutableStateOf(true)
    }
    var isYes by remember{
        mutableStateOf(false)
    }

    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp)
    ){

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Settings", fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
        }
        Spacer(Modifier.height(20.dp))

        LazyColumn {
            item{
                Text("Notifications", fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                        secondColor).padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Notifications", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.weight(1f))
                    Switch(isNot, {isNot = it}, colors = SwitchDefaults.colors(
                        checkedThumbColor = lightBlue,
                        uncheckedThumbColor = bck,
                        checkedTrackColor = bck,
                        uncheckedTrackColor = bck,
                    ))
                }
                Spacer(Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                        secondColor).padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("App notifications", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.weight(1f))
                    Switch(isYes, {isYes = it}, colors = SwitchDefaults.colors(
                        checkedThumbColor = lightBlue,
                        uncheckedThumbColor = bck,
                        checkedTrackColor = bck,
                        uncheckedTrackColor = bck,
                    ))
                }
            }
            item{
                Spacer(Modifier.height(20.dp))
                Text("Account", fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                        secondColor).padding(16.dp).noRippleClickable { terms() },
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Terms and Conditions", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.weight(1f))
                    Icon(Icons.Rounded.KeyboardArrowRight, "", tint = Color.White,
                        modifier = Modifier.size(24.dp))
                }
                Spacer(Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                        secondColor).padding(16.dp).noRippleClickable { privacy() },
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Privacy Policy", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.weight(1f))
                    Icon(Icons.Rounded.KeyboardArrowRight, "", tint = Color.White,
                        modifier = Modifier.size(24.dp))
                }
            }
        }
    }

}