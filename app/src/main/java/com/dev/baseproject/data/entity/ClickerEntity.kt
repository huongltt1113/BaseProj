package com.dev.baseproject.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "clicker_entity")
data class ClickerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id: Int? = null,

    @ColumnInfo(name = "idScript")
    @SerializedName("idScript")
    var idScript: Int? = null,

) : Serializable {

}