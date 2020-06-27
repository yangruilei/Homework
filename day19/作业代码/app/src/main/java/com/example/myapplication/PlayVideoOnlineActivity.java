package com.example.myapplication;

import android.app.Activity;
import android.net.Uri;

import android.os.Bundle;
import android.widget.Toast;



import java.util.Random;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;

import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

/**
 * 使用vitamio播放视频
 * @version 1.0.0
 * @author 桑博
 */
public class PlayVideoOnlineActivity extends Activity {

    private VideoView mVideoView;

    private String[] video = {
            "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4",
            "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4",
            "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_play_video_online);
//        m_actionBar.hide();
        playfunction();

    }

    void playfunction(){
        String path = "";
        path = video[new Random().nextInt(video.length)];
        if (path == "") {
            Toast.makeText(this, "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4", Toast.LENGTH_LONG).show();
            return;
        }
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(path);   //设置视频网络地址
//      mVideoView.setVideoURI(Uri.parse(path)); //也可以是本地,也可以是网络地址
        mVideoView.setMediaController(new MediaController(this)); //设置媒体控制器
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);   //设置视频的缩放参数,这里设置为拉伸
        mVideoView.requestFocus();
        //视频播放器的准备,此时播放器已经准备好了,此处可以设置一下播放速度,播放位置等等
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //此处设置播放速度为正常速度1
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
        //当播放完成后,从头开始
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);   //转到第一帧
                mediaPlayer.start();     //开始播放
            }
        });

    }
}
