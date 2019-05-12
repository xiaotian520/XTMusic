package xtmusic.xiaotian.com.xtmusic.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.helps.MediaPlayerHelp;
import xtmusic.xiaotian.com.xtmusic.helps.UserHelper;
import xtmusic.xiaotian.com.xtmusic.services.MusicService;
import xtmusic.xiaotian.com.xtmusic.utils.UserUtils;
import xtmusic.xiaotian.com.xtmusic.views.PlayMusicView;

public class MeActivity extends BaseActivity {

    private TextView mTvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initView();

    }

    /**
     * 初始化NavBar
     */
    private void initView(){
        initNavBar(true,"个人中心",false);
        mTvUser = findViewById(R.id.tv_user);
        mTvUser.setText("用户名：" + UserHelper.getInstance().getPhone());
    }

    /**
     * 修改密码点击事件
     */
    public void onChangeClick(View view){
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }
    /**
     * 退出登录
     */
    public void onLogoutClick(View view){

        UserUtils.logout(this);
    }
}
