package com.finance.rjdjds.ui.screens.wallet

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.data.db.Day
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.blue
import com.finance.rjdjds.ui.components.darkGrey
import com.finance.rjdjds.ui.components.grey
import com.finance.rjdjds.ui.components.noRippleClickable

@Composable
fun IncomeScreen(
    back: () -> Unit,
    add: (Day) -> Unit
) {

    var date by remember{
        mutableStateOf("")
    }
    var amount by remember{
        mutableStateOf("")
    }
    var description by remember{
        mutableStateOf("")
    }


    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp)
    ) {

        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box(
                Modifier.align(Alignment.CenterStart).size(40.dp).clip(CircleShape).background(
                    darkGrey).noRippleClickable { back() },
                contentAlignment = Alignment.Center
            ){
                Icon(Icons.Rounded.KeyboardArrowLeft, "", tint = Color.White,
                    modifier = Modifier.size(24.dp))
            }
            Text(
                "Walet",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            date, {date = it}, colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = grey,
                focusedBorderColor = Color.White.copy(alpha = 0f),
                cursorColor = Color.White,
            ),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text("Payment date", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFFEBEBF5).copy(alpha = 0.3f))
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Medium),
            modifier = Modifier.fillMaxWidth().height(65.dp),

        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            amount, {
                var t = true
                it.forEach { i->
                    if (!i.isDigit()){
                        t = false
                    }
                }
                if (t){
                    amount = it
                }
            }, colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = grey,
                focusedBorderColor = Color.White.copy(alpha = 0f),
                cursorColor = Color.White,
            ),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text("Amount", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFFEBEBF5).copy(alpha = 0.3f))
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next, keyboardType = KeyboardType.Number),
            keyboardActions = KeyboardActions(onNext = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Medium),
            modifier = Modifier.fillMaxWidth().height(65.dp),

            )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            description, {description = it}, colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = grey,
                focusedBorderColor = Color.White.copy(alpha = 0f),
                cursorColor = Color.White,
            ),
            shape = RoundedCornerShape(16.dp),
            placeholder = {
                Text("Description", fontSize = 14.sp, fontWeight = FontWeight.Medium, color = Color(0xFFEBEBF5).copy(alpha = 0.3f))
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }),
            textStyle = TextStyle(fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Medium),
            modifier = Modifier.fillMaxWidth().height(65.dp),

            )
        Spacer(Modifier.height(20.dp))
        Box(Modifier.padding(vertical = 4.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
            blue
        ).padding(vertical = 25.dp).noRippleClickable {
            add(
                Day(
                    date = date,
                    isIncome = true,
                    amount = amount.toInt()
                )
            )
            back()
        }, contentAlignment = Alignment.Center){
            Text("Calculate", fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color.White)
        }
    }

}