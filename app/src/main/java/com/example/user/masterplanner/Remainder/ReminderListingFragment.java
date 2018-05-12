package com.example.user.masterplanner.Remainder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.masterplanner.BaseApplication;
import com.example.user.masterplanner.Models.Remainder;
import com.example.user.masterplanner.R;
import com.example.user.masterplanner.Remainder.RemainderDialog.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by emmanuel on 2018-04-20.
 */


public class ReminderListingFragment extends Fragment implements RemainderListingView,
        View.OnClickListener{
    private OnRemainderFragmentAttach fragmentAttach;

    @Inject
    Presenter presenter;


    @BindView(R.id.addFab)
    private FloatingActionButton addFab;
    @BindView(R.id._remainder_recyclerView)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private LoadingDialog loadingDialog;

    private List<Remainder> remainderList = new ArrayList<>(20);
    private RemainderAdapter remainderAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentAttach = (OnRemainderFragmentAttach) context;
        }catch (ClassCastException e){
            throw new ClassCastException("Can't cast this shitty class: piss off man");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApplication)getActivity().getApplication()).addRemainderListingComponent()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remainder_listing_fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        addFab = ButterKnife.findById(view, R.id.addFab);
        recyclerView = view.findViewById(R.id._remainder_recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.setView(this);
        initLayout();
        addFab.setOnClickListener(this);
    }

    private void initLayout(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        remainderAdapter = new RemainderAdapter(getContext(), this.remainderList);
        recyclerView.setAdapter(remainderAdapter);
    }


    @Override
    public void displayReminders(List<Remainder> remainderList){
        if (remainderList != null){
            if (!remainderList.isEmpty()){
                this.remainderList.clear();
                this.remainderList.addAll(remainderList);
                remainderAdapter.notifyDataSetChanged();
            }else {
                //todo: show the empty layout
            }

        }

    }


    @Override
    public void displayLoadingView() {
        loadingDialog = new LoadingDialog();
        loadingDialog.show(getFragmentManager(), "loadingView");
    }

    private void removeLoadingView(){
        loadingDialog.dismissLoadingDialog();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addFab:
                fragmentAttach.onAddReminderClicked();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume", "OnResume");
        presenter.setView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("onPause", "onPause");
        presenter.destroyView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.destory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ((BaseApplication)getActivity().getApplication())
                .realeaseListingRemainderComponent();
    }

    interface OnRemainderFragmentAttach{
        void onAddReminderClicked();
    }
}
