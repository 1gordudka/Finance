package com.finance.rjdjds.data.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(
    entities = [Day::class],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class FinanceDatabase : RoomDatabase() {

    abstract fun dayDao() : DayDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<FinanceDatabase>