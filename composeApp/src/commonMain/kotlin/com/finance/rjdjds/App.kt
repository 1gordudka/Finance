package com.finance.rjdjds

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.finance.rjdjds.data.db.DayDao
import com.finance.rjdjds.data.local.tips
import com.finance.rjdjds.ui.GAME
import com.finance.rjdjds.ui.INCOME
import com.finance.rjdjds.ui.OUTCOME
import com.finance.rjdjds.ui.POLICY
import com.finance.rjdjds.ui.QUIZ
import com.finance.rjdjds.ui.SETTINGS
import com.finance.rjdjds.ui.TERMS
import com.finance.rjdjds.ui.TIPS
import com.finance.rjdjds.ui.TIPS_DET
import com.finance.rjdjds.ui.WALLET
import com.finance.rjdjds.ui.components.BottomBar
import com.finance.rjdjds.ui.components.bck
import com.finance.rjdjds.ui.screens.game.GameScreen
import com.finance.rjdjds.ui.screens.policy
import com.finance.rjdjds.ui.screens.quiz.QuizScreen
import com.finance.rjdjds.ui.screens.settings.SettingsScreen
import com.finance.rjdjds.ui.screens.settings.TextScreen
import com.finance.rjdjds.ui.screens.terms
import com.finance.rjdjds.ui.screens.tips.TipDetail
import com.finance.rjdjds.ui.screens.tips.TipsScreen
import com.finance.rjdjds.ui.screens.wallet.IncomeScreen
import com.finance.rjdjds.ui.screens.wallet.OutcomeScreen
import com.finance.rjdjds.ui.screens.wallet.WalletScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import finance.composeapp.generated.resources.Res
import finance.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch

@Composable
fun App(
    dao: DayDao
) {

    val navController = rememberNavController()
    var showBottomBar by remember { mutableStateOf(false) }
    var dest by remember { mutableStateOf("") }

    val days by dao.getAllDays().collectAsState(initial = emptyList())

    var tip by remember {
        mutableStateOf(-1)
    }
    val scope = rememberCoroutineScope()

    var balance by remember { mutableStateOf(0) }

    LaunchedEffect(days){
        balance = 0
        days.forEach {
            if (it.isIncome){
                balance += it.amount
            }else{
                balance -= it.amount
            }
        }
    }

    LaunchedEffect(navController) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            dest = destination.route.toString()
            showBottomBar = when (destination.route) {
                WALLET -> true
                TIPS -> true
                SETTINGS -> true
                QUIZ -> true
                GAME -> true
                else -> false
            }
        }
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar){
                BottomBar(dest){
                    navController.navigate(it)
                }
            }
        },
    ){pd->

        NavHost(
            navController, WALLET,
            modifier = Modifier.padding(pd).fillMaxSize().background(bck)
        ){
            composable(GAME){
                GameScreen()
            }
            composable(WALLET){
                WalletScreen(balance, days, {
                    navController.navigate(INCOME)
                }, {
                    navController.navigate(OUTCOME)
                })
            }
            composable(QUIZ){
                QuizScreen()
            }
            composable(SETTINGS){
                SettingsScreen({navController.navigate(POLICY)}, {navController.navigate(TERMS)})
            }
            composable(TIPS){
                TipsScreen {
                    tip = it
                    navController.navigate(TIPS_DET)
                }
            }
            composable(TIPS_DET){
                TipDetail(tips[tip], {
                    navController.popBackStack()
                })
            }
            composable(POLICY){
                TextScreen(policy, {navController.popBackStack()})
            }
            composable(TERMS){
                TextScreen(terms, {navController.popBackStack()})
            }
            composable(INCOME){
                IncomeScreen({navController.popBackStack()}){
                    scope.launch {
                        dao.addDay(it)
                    }
                }
            }
            composable(OUTCOME){
                OutcomeScreen({navController.popBackStack()}){
                    scope.launch {
                        dao.addDay(it)
                    }
                }
            }
        }

    }

}