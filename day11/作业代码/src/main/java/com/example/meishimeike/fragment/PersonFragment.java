package com.example.meishimeike.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.meishimeike.LoginActivity;
import com.example.meishimeike.R;


public class PersonFragment extends Fragment {
    private ImageView mHead;
    private TextView mOrRegistLogin;
    private ImageView mEdit;
    private TextView mYuekeGo;
    private TextView mClassNumMy;
    private TextView mClassMy;
    private TextView mYuekeNumMy;
    private TextView mYuekeMy;
    private TextView mStudyBiMy;
    private TextView mMyStudySheng;
    private ConstraintLayout mJoinCon;
    private TextView mClassAboutTv;
    private ImageView mTextIv;
    private ImageView mAboutIv;
    private ImageView mCollectIv;
    private ImageView mDownloadIv;
    private TextView mRelatedOrder;
    private ImageView mMyOrderIv;
    private ImageView mMyAdressIv;
    private TextView mZhanghaoMy;
    private ImageView mYouhuijuanIv;
    private ImageView mStudyCardIv;
    private ImageView mHuiyuanVipIv;
    private TextView mServiceZizhu;
    private ImageView mMyMessageIv;
    private ImageView mYijianFankuiIv;
    private ImageView mOnlineKefuIv;
    private ImageView mSettingIv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.person, null);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mHead = (ImageView) itemView.findViewById(R.id.head);
        mOrRegistLogin = (TextView) itemView.findViewById(R.id.login_or_regist);
        mEdit = (ImageView) itemView.findViewById(R.id.edit);
        mYuekeGo = (TextView) itemView.findViewById(R.id.go_yueke);
        mClassNumMy = (TextView) itemView.findViewById(R.id.my_class_num);
        mClassMy = (TextView) itemView.findViewById(R.id.my_class);
        mYuekeNumMy = (TextView) itemView.findViewById(R.id.my_yueke_num);
        mYuekeMy = (TextView) itemView.findViewById(R.id.my_yueke);
        mStudyBiMy = (TextView) itemView.findViewById(R.id.my_study_bi);
        mMyStudySheng = (TextView) itemView.findViewById(R.id.sheng_my_study);
        mJoinCon = (ConstraintLayout) itemView.findViewById(R.id.con_join);
        mClassAboutTv = (TextView) itemView.findViewById(R.id.tv_class_about);
        mTextIv = (ImageView) itemView.findViewById(R.id.iv_text);
        mAboutIv = (ImageView) itemView.findViewById(R.id.iv_about);
        mCollectIv = (ImageView) itemView.findViewById(R.id.iv_collect);
        mDownloadIv = (ImageView) itemView.findViewById(R.id.iv_download);
        mRelatedOrder = (TextView) itemView.findViewById(R.id.order_related);
        mMyOrderIv = (ImageView) itemView.findViewById(R.id.iv_my_order);
        mMyAdressIv = (ImageView) itemView.findViewById(R.id.iv_my_adress);
        mZhanghaoMy = (TextView) itemView.findViewById(R.id.my_zhanghao);
        mYouhuijuanIv = (ImageView) itemView.findViewById(R.id.iv_youhuijuan);
        mStudyCardIv = (ImageView) itemView.findViewById(R.id.iv_study_card);
        mHuiyuanVipIv = (ImageView) itemView.findViewById(R.id.iv_huiyuan_vip);
        mServiceZizhu = (TextView) itemView.findViewById(R.id.zizhu_service);
        mMyMessageIv = (ImageView) itemView.findViewById(R.id.iv_my_message);
        mYijianFankuiIv = (ImageView) itemView.findViewById(R.id.iv_yijian_fankui);
        mOnlineKefuIv = (ImageView) itemView.findViewById(R.id.iv_online_kefu);
        mSettingIv = (ImageView) itemView.findViewById(R.id.iv_setting);
        inittextview();
    }

    private void inittextview() {
        mOrRegistLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(intent);

            }
        });
    }
}
