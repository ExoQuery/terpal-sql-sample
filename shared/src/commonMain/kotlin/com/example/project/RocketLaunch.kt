package com.example.project

import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class RocketLaunch(
    @SerialName("flight_number")
    val flightNumber: Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("details")
    val details: String?,
    @SerialName("success")
    val launchSuccess: Boolean?,
    @SerialName("date_utc")
    val launchDateUTC: String,
    @SerialName("links")
    val links: Links
) {
    @Transient
    var launchYear = launchDateUTC.toInstant().toLocalDateTime(TimeZone.UTC).year
}

@Serializable
data class Links(
    @SerialName("patch")
    val patch: Patch?,
    @SerialName("article")
    val article: String?
)

@Serializable
data class Patch(
    @SerialName("small")
    val small: String?,
    @SerialName("large")
    val large: String?
)
