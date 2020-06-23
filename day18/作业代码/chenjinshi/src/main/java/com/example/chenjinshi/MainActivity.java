package com.example.chenjinshi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mOneBtn;
    private Button mTwoBtn;
    private Button mThreeBtn;
    private Button mFourBtn;
    private Button mFiveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mOneBtn = (Button) findViewById(R.id.btn_one);
        mOneBtn.setOnClickListener(this);
        mTwoBtn = (Button) findViewById(R.id.btn_two);
        mTwoBtn.setOnClickListener(this);
        mThreeBtn = (Button) findViewById(R.id.btn_three);
        mThreeBtn.setOnClickListener(this);
        mFourBtn = (Button) findViewById(R.id.btn_four);
        mFourBtn.setOnClickListener(this);
        mFiveBtn = (Button) findViewById(R.id.btn_five);
        mFiveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                // TODO 20/06/23
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_two:
                // TODO 20/06/23
                Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_three:
                // TODO 20/06/23
                Intent intent3 = new Intent(MainActivity.this, ThreeActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_four:// TODO 20/06/23
                break;
            case R.id.btn_five:// TODO 20/06/23
                break;
            default:
                break;
        }
    }
//    private void showShare() {
//        OnekeyShare oks = new OnekeyShare();
//        //关闭sso授权
//        oks.disableSSOWhenAuthorize();
//
//        // title标题，微信、QQ和QQ空间等平台使用
//        oks.setTitle(getString(R.string.share));
//        // titleUrl QQ和QQ空间跳转链接
//        oks.setTitleUrl("http://sharesdk.cn");
//        // text是分享文本，所有平台都需要这个字段
//        oks.setText("我是分享文本");
//        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
//        // url在微信、微博，Facebook等平台中使用
//        oks.setUrl("http://sharesdk.cn");
//        // comment是我对这条分享的评论，仅在人人网使用
//        oks.setComment("我是测试评论文本");
//        // 启动分享GUI
//        oks.show(this);
//    }
}
