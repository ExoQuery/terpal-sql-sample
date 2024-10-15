package com.example.project.cache

import com.example.project.RocketLaunch
import io.exoquery.sql.Query
import io.exoquery.sql.Sql

object DAO {
    fun selectAllLaunchesInfo(): Query<RocketLaunch> =
        Sql("SELECT * FROM Launch").queryOf<RocketLaunch>()

    fun removeAllLaunches() =
        Sql("DELETE FROM Launch").action()

    fun insertLaunch(rl: RocketLaunch) =
      Sql(
        """
           INSERT INTO Launch (
             flightNumber, missionName, details, launchSuccess, launchDateUTC, patchUrlSmall, patchUrlLarge, articleUrl) 
           VALUES 
             (${rl.flightNumber}, ${rl.missionName}, ${rl.details}, ${rl.launchSuccess}, ${rl.launchDateUTC}, ${rl.links.patch?.small}, ${rl.links.patch?.large}, ${rl.links.article}) 
        """
      )
}