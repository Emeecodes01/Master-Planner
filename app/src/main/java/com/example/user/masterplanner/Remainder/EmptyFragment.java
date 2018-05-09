package com.example.user.masterplanner.Remainder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.masterplanner.R;

/**
 * Created by emmanuel on 2018-05-08.
 */

public class EmptyFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.empty_layout, container, false);
    }
}
