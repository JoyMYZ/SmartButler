package com.example.user.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.smartbutler.R;

/**
 * Project_name:   SmartButler
 * Package_name:   com.example.user.smartbutler.fragment
 * User:           ${User}
 * Date&Time:      2018/2/16 15:04
 * Description:    TODO
 **/

public class GirlFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_girls,null);
        return view;
    }
}
