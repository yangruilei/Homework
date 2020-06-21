package com.example.huadongchongtu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FourFragment extends Fragment {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private RecyclerView mRecyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_four, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mButton1 = (Button) itemView.findViewById(R.id.button1);
        mButton2 = (Button) itemView.findViewById(R.id.button2);
        mButton3 = (Button) itemView.findViewById(R.id.button3);
        mRecyclerview = (RecyclerView) itemView.findViewById(R.id.recyclerview);
        List<String> list=new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(i+1+"--");
        }

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycle_adapter recycle_adapter = new recycle_adapter(list,getContext());
        mRecyclerview.setAdapter(recycle_adapter);
    }

}
