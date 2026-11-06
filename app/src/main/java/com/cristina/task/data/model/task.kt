package com.cristina.task.data.model

import android.os.Parcelable
import com.marta.task.data.model.Status
import kotlinx.parcelize.Parcelize

@Parcelize
data class Task(
    var id: String = "",
    var description: String = "",
    var status: Status = Status.TODO
) : Parcelable