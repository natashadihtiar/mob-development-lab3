package com.example.lab2

import android.os.Parcel
import android.os.Parcelable

//Создание объекта и передача другой активности
class MusicBand(var avatarId: Int, var name: String?, var state: String?, var year: Int, var about: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }
//Запись данных
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(avatarId)
        parcel.writeString(name)
        parcel.writeString(state)
        parcel.writeInt(year)
        parcel.writeString(about)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MusicBand> {
        override fun createFromParcel(parcel: Parcel): MusicBand {
            return MusicBand(parcel)
        }

        override fun newArray(size: Int): Array<MusicBand?> {
            return arrayOfNulls(size)
        }
    }
}