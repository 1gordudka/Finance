package com.finance.rjdjds.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("days")
data class Day (
    @PrimaryKey(true) val id: Int = 0,
    val date: String,
    val isIncome: Boolean,
    val amount: Int,
)