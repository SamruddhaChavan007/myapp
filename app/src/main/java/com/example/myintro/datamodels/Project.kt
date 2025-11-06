package com.example.myintro.datamodels

data class Project(
    val title: String,
    val subtitle: String,
    val description: String,
    val tech: List<String>,
    val link: String? = null
)
