package xtmusic.xiaotian.com.xtmusic.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.adapters.MusicListAdapter;
import xtmusic.xiaotian.com.xtmusic.helps.RealmHelper;
import xtmusic.xiaotian.com.xtmusic.models.AlbumModel;

public class AlbumListActivity extends BaseActivity {

    public static final String ALBUM_ID = "albumId";

    private RecyclerView mRvList;
    private MusicListAdapter mListAdapter;
    private String mAlbumId;
    private RealmHelper mRealmHelper;
    private AlbumModel mAlbumModel;
    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_list);

        initData();
        initView();
    }

    private void initData () {
        mAlbumId = getIntent().getStringExtra(ALBUM_ID);
        mRealmHelper = new RealmHelper();
        mAlbumModel = mRealmHelper.getAlbum(mAlbumId);
    }


    private void initView() {
        initNavBar(true, "专辑列表", false);

        mRvList = findViewById(R.id.rv_list);
        mTvName = findViewById(R.id.tv_name);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mTvName.setText(mAlbumModel.getName());
        mListAdapter = new MusicListAdapter(this, null,  mAlbumModel.getList());
        mRvList.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mRealmHelper.close();
    }
}
