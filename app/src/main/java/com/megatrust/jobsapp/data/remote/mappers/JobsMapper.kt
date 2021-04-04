package com.megatrust.jobsapp.data.remote.mappers

import com.megatrust.jobsapp.data.remote.entites.JobResponse
import com.megatrust.jobsapp.ui.home.Job

fun JobResponse.toJob(): Job? {
    if (company == null || description == null || id == null || title == null) return null

    return Job(
        id = id,
        companyName = company,
        companyLogo = company_logo,
        companyUrl = company_url,
        createdAt = created_at,
        description = description,
        howToApply = how_to_apply,
        location = location,
        title = title,
        type = type,
        url = url
    )
}