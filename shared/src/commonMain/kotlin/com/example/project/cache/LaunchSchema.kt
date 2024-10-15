package com.example.project.cache

import io.exoquery.sql.Sql
import io.exoquery.sql.TerpalDriver
import io.exoquery.sql.runOn
import io.exoquery.sql.sqlite.CallAfterVersion
import io.exoquery.sql.sqlite.TerpalSchema

object LaunchSchema: TerpalSchema<Unit> {
    override val version: Long
        get() = 1

    override suspend fun create(driver: TerpalDriver) {
        Sql(
          """
            CREATE TABLE Launch (
                flightNumber INTEGER NOT NULL,
                missionName TEXT NOT NULL,
                details TEXT,
                launchSuccess INTEGER DEFAULT NULL,
                launchDateUTC TEXT NOT NULL,
                patchUrlSmall TEXT,
                patchUrlLarge TEXT,
                articleUrl TEXT
            )
        """
        ).action().runOn(driver)
    }

    override suspend fun migrate(driver: TerpalDriver, oldVersion: Long, newVersion: Long, vararg callbacks: CallAfterVersion) {
        // No-op
    }
}