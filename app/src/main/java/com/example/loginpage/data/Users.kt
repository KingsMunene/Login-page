package com.example.loginpage.data

class User(val username: String, val password: String)


val users: List<User> = listOf(
    User("kings", "1234"),
    User("bancy", "abc"),
    User("pam", "juniour")
)