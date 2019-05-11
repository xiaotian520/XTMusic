package xtmusic.xiaotian.com.xtmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.utils.UserUtils;
import xtmusic.xiaotian.com.xtmusic.views.InputView;

// NavigationBar
public class LoginActivity extends BaseActivity {

    private InputView mInputPhone,mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

     /**
      * 初始化View
      */
    private  void initView(){
        /*控制登录页面的NavBar*/
        initNavBar(false,"登录",false);

        mInputPhone = findViewById(R.id.input_phone);
        mInputPassword = findViewById(R.id.input_password);
    }

     /**
      * onRegisterClick
      * 跳转注册页面点击事件
      */
     public void onRegisterClick(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
     }

    /**
     * 登陆
     */
    public void onCommitClick(View view){

        String phone = mInputPhone.getInputStr();
        String password = mInputPassword.getInputStr();

        /*验证用户输入是否合法*/
        if (!UserUtils.validateLogin(this,phone,password)){
            return;
        }
        /*跳转到应用主页*/
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
