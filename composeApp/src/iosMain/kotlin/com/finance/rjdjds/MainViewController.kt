package com.finance.rjdjds

import androidx.compose.ui.window.ComposeUIViewController
import com.finance.rjdjds.data.getFinanceDatabase

fun MainViewController() = ComposeUIViewController {
    App(dao = getFinanceDatabase().dayDao())
}