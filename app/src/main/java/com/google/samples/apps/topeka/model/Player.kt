package com.google.samples.apps.topeka.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by huangpeng on 7/30/16.
 */


/**
 * Stores values to identify the subject that is currently attempting to solve quizzes.
 */
open class Player(val firstName: String, val lastInitial: String, val avatar: Avatar) : Parcelable {
    protected constructor(`in`: Parcel): this(`in`.readString(), `in`.readString(), Avatar.values()[`in`.readInt()]) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(firstName)
        dest.writeString(lastInitial)
        dest.writeInt(avatar.ordinal)
    }

    @SuppressWarnings("RedundantIfStatement")
    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }

        val player = o as Player?

        if (avatar !== player!!.avatar) {
            return false
        }
        if (firstName != player!!.firstName) {
            return false
        }
        if (lastInitial != player.lastInitial) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastInitial.hashCode()
        result = 31 * result + avatar.hashCode()
        return result
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Player> = object : Parcelable.Creator<Player> {
            override fun createFromParcel(`in`: Parcel): Player {
                return Player(`in`)
            }

            override fun newArray(size: Int): Array<Player?> {
                return arrayOfNulls(size)
            }
        }
    }
}