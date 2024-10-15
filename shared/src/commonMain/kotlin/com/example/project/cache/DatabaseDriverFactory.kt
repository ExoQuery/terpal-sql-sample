package com.example.project.cache

import app.cash.sqldelight.db.SqlDriver
import io.exoquery.sql.TerpalDriver

interface DatabaseDriverFactory {
  fun createTerpalDriver(): TerpalDriver
}