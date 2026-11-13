package com.cristina.task.data.model

data class Task(
    var id: String = "",
    var description: String = "",
    var status: Status = Status.TODO
)