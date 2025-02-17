package com.finance.rjdjds.ui.screens.quiz

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.finance.rjdjds.data.local.questions
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.components.blue
import com.finance.rjdjds.ui.components.grey
import com.finance.rjdjds.ui.components.noRippleClickable

val moneyEmoji = "💵"
val victoryEmoji = "🎉"
@Composable
fun QuizScreen() {

    var question by remember { mutableStateOf(0) }
    var correct by remember { mutableStateOf(0) }
    var answer by remember { mutableStateOf(-1) }
    var isCorrect by remember { mutableStateOf(false) }
    var isWin by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize().background(bck).statusBarsPadding().padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Quiz",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(Modifier.height(20.dp))
        LazyColumn(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item{
               if (isWin){
                   Finish(correct)
                   Spacer(Modifier.height(30.dp))
                   Box(Modifier.padding(vertical = 4.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                      blue).padding(vertical = 25.dp).noRippleClickable {

                          question = 0
                       correct = 0
                       answer = -1
                       isCorrect = false
                       isWin = false
                   }, contentAlignment = Alignment.Center){
                       Text("Done", fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color.White)
                   }
               }else{
                   if (isCorrect){
                       CorrectAnswer()
                   }else{
                       Text("Question - ${question+1}", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.White)
                       Spacer(Modifier.height(10.dp))
                       Text(questions[question].name, fontSize = 26.sp, color = Color.White, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
                       Spacer(Modifier.height(10.dp))
                       questions[question].answers.forEach {
                           Box(Modifier.padding(vertical = 4.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                               if (answer == questions[question].answers.indexOf(it)) blue else grey).padding(vertical = 25.dp).noRippleClickable {
                               answer = questions[question].answers.indexOf(it)
                           }, contentAlignment = Alignment.Center){
                               Text(it, fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color.White)
                           }
                       }
                   }
                   Spacer(Modifier.height(20.dp))
                   Box(Modifier.padding(vertical = 4.dp).fillMaxWidth().clip(RoundedCornerShape(16.dp)).background(
                       if (answer != -1 || isCorrect) blue else grey).padding(vertical = 25.dp).noRippleClickable {
                       if (isCorrect){
                           answer = -1
                           if (question != questions.lastIndex){
                               question++
                           }else{
                               isWin = true
                           }
                           isCorrect = false
                       }else{
                           if (answer != -1){
                               if (answer == questions[question].correct){
                                   correct++
                                   isCorrect = true
                               }else{
                                   answer = -1
                               }
                               if (question != questions.lastIndex){
                                   question++
                               }else{
                                   isWin = true
                               }
                           }
                       }
                   }, contentAlignment = Alignment.Center){
                       Text("Next", fontWeight = FontWeight.Medium, fontSize = 16.sp, color = Color.White.copy(alpha = if (answer != -1) 1f else 0.6f))
                   }
               }
            }
        }
    }
}

@Composable
fun Finish(
    correct: Int
) {

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(victoryEmoji, fontSize = 100.sp)
        Spacer(Modifier.height(35.dp))
        Text("Congratulation!\nYou did it great", fontSize = 26.sp, fontWeight = FontWeight.Medium, color = Color.White, textAlign = TextAlign.Center)
        Spacer(Modifier.height(15.dp))
        Row (
            Modifier.clip(RoundedCornerShape(16.dp)).background(blue).padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text("Correct answers ${correct}/15", fontSize = 15.sp, color = Color.White, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun CorrectAnswer(

) {

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("That`s the correct answer", fontSize = 26.sp, fontWeight = FontWeight.Medium, color = Color.White)
        Spacer(Modifier.height(35.dp))
        Text(moneyEmoji, fontSize = 100.sp)
    }

}