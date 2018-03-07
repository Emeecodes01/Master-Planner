package com.example.user.masterplanner.Remainder.RemainderDialog.RingTone;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by emmanuel on 2018-05-11.
 */

public class RingTone implements Parcelable{
    private String name;
    private String ringtoneUri;

    public RingTone(String name, String ringtoneUri) {
        this.name = name;
        this.ringtoneUri = ringtoneUri;
    }

    protected RingTone(Parcel in) {
        name = in.readString();
        ringtoneUri = in.readString();
    }

    public static final Creator<RingTone> CREATOR = new Creator<RingTone>() {
        @Override
        public RingTone createFromParcel(Parcel in) {
            return new RingTone(in);
        }

        @Override
        public RingTone[] newArray(int size) {
            return new RingTone[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getRingtoneUri() {
        return ringtoneUri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(ringtoneUri);
    }
}
