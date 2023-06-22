package com.example.cw2_227020684

import android.os.Parcel
import android.os.Parcelable

data class ToolDataClass(var toolImage:Int, var toolTitle:String, var toolDetailImage: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(toolImage)
        parcel.writeString(toolTitle)
        parcel.writeInt(toolDetailImage)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<ToolDataClass> {
        override fun createFromParcel(parcel: Parcel): ToolDataClass {
            return ToolDataClass(parcel)
        }
        override fun newArray(size: Int): Array<ToolDataClass?> {
            return arrayOfNulls(size)
        }
    }
}