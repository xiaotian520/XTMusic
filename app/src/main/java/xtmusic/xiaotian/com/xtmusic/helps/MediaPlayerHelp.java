package xtmusic.xiaotian.com.xtmusic.helps;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;

public class MediaPlayerHelp {

    private static MediaPlayerHelp instance;

    private Context mContext;
    private MediaPlayer mMediaPlayer;
    private String mPath;
    private OnMediaPlayerHelperListener onMediaPlayerHelperListener;

    public void setOnMediaPlayerHelperListener(OnMediaPlayerHelperListener onMediaPlayerHelperListener) {
        this.onMediaPlayerHelperListener = onMediaPlayerHelperListener;
    }

    public static MediaPlayerHelp getInstance(Context context){
        if (instance == null){
            synchronized (MediaPlayerHelp.class){
                if (instance == null){
                    instance = new MediaPlayerHelp(context);
                }
            }
        }
        return instance;
    }

    private MediaPlayerHelp (Context context){
        mContext = context;
        mMediaPlayer = new MediaPlayer();
    }

    /**
     * 1、 setPath: 当前需要播放的音乐
     * 2、 start:   播放音乐
     * 3、 paus:    停止播放
     */

    //当前需要播放的音乐
    public void setPath(String path){
        /**
         * 1、 音乐正在播放，重置音乐播放状态
         * 2、 设置播放音乐路径
         * 3、 准备播放
         */


         //1、 音乐正在播放，重置音乐播放状态
        if (mMediaPlayer.isPlaying() || !path.equals(mPath)){
            mMediaPlayer.reset();
        }
        mPath = path;

        //2、 设置播放音乐路径
        try {
            mMediaPlayer.setDataSource(mContext, Uri.parse(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3、 准备播放
        mMediaPlayer.prepareAsync();//异步加载
        /*捕获异步加载完成通知*/
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                //外放通知
                if (onMediaPlayerHelperListener != null){
                    onMediaPlayerHelperListener.onPrepared(mp);
                }
            }
        });
        //监听音乐播放完成
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (onMediaPlayerHelperListener != null) {
                    onMediaPlayerHelperListener.onCompletion(mp);
                }
            }
        });
    }



    //返回正在播放的音乐路径
    public String getPath(){
        return mPath;
    }

    //播放音乐
    public void start(){
        if (mMediaPlayer.isPlaying()){return;}
        mMediaPlayer.start();
    }

    //停止播放
    public void pause(){
        mMediaPlayer.pause();
    }

    //外放通知接口     onMediaPlayerHelperListener
    public interface OnMediaPlayerHelperListener{
        void onPrepared(MediaPlayer mp);
        void onCompletion(MediaPlayer mp);
    }


}
