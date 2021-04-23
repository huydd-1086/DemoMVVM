package com.sun.demomvvm.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "FavoriteProduct")
data class Product(
    @PrimaryKey
    @ColumnInfo
    @SerializedName("id")
    val id: String,
    @ColumnInfo
    @SerializedName("title")
    val title: String,
    @ColumnInfo
    @SerializedName("price")
    val price: String,
    @ColumnInfo
    @SerializedName("description")
    val description: String,
    @ColumnInfo
    @SerializedName("category")
    val category: String,
    @ColumnInfo
    @SerializedName("image")
    val image: String
) : Parcelable
