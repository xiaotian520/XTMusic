package xtmusic.xiaotian.com.xtmusic;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

import io.realm.Realm;
import xtmusic.xiaotian.com.xtmusic.helps.RealmHelper;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /*初始化AndroidUtilCode类库*/
        Utils.init(this);
        Realm.init(this);

        RealmHelper.migration();
    }
}
