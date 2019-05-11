package xtmusic.xiaotian.com.xtmusic.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import xtmusic.xiaotian.com.xtmusic.R;

public class BaseActivity extends Activity {

    private ImageView mIvBack,mIvMe;
    private TextView mTvTiele;

    /**
     * 控制NavBar的显示,chu'shi初始化NavgationBar
     * @param isShowBack
     * @param title
     * @param isShowMe
     */
    protected void initNavBar(boolean isShowBack,String title,boolean isShowMe){
        mIvBack = findViewById(R.id.iv_back);
        mIvMe = findViewById(R.id.iv_me);
        mTvTiele = findViewById(R.id.tv_title);
        /*判断三个组件的显示与隐藏*/
        mIvBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
        mIvMe.setVisibility(isShowMe ? View.VISIBLE : View.GONE);
        mTvTiele.setText(title);

        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();//执行后退操作
            }
        });

        mIvMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,MeActivity.class);
                startActivity(intent);
            }
        });
    }


}
