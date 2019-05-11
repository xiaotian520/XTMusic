package xtmusic.xiaotian.com.xtmusic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.utils.UserUtils;
import xtmusic.xiaotian.com.xtmusic.views.InputView;

public class ChangePasswordActivity extends BaseActivity {

    private InputView mOldPassword, mPassword, mPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        initView();
    }

    private void initView() {
        initNavBar(true, "修改密码",false);

        mOldPassword = findViewById(R.id.input_oldpassword);
        mPassword = findViewById(R.id.input_newpassword);
        mPasswordConfirm = findViewById(R.id.input_repassword);
    }

    public void onChangePasswordClick (View v) {
        String oldPassword = mOldPassword.getInputStr();
        String password = mPassword.getInputStr();
        String passwordConfirm = mPasswordConfirm.getInputStr();

        boolean result = UserUtils.changePassword(this, oldPassword, password, passwordConfirm);
        if (!result) {
            return;
        }

        UserUtils.logout(this);
    }
}
