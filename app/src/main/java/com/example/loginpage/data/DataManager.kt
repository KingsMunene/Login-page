package com.example.loginpage.data

object DataManager {
    val users = HashMap<String, User>()

    init{
        initializeUsers()
    }

    private fun initializeUsers(){

        var u1 = User("kings", "1234")
        users[u1.userName] = u1
        u1 = User("bancy", "abc")
        users[u1.userName] = u1
        u1 = User("pam", "juniour")
        users[u1.userName] = u1


    }
}