package xtmusic.xiaotian.com.xtmusic.activities;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.adapters.MusicGridAdapter;
import xtmusic.xiaotian.com.xtmusic.adapters.MusicListAdapter;
import xtmusic.xiaotian.com.xtmusic.helps.RealmHelper;
import xtmusic.xiaotian.com.xtmusic.models.MusicModel;
import xtmusic.xiaotian.com.xtmusic.models.MusicSourceModel;
import xtmusic.xiaotian.com.xtmusic.views.GridSpaceItemDecoration;

public class MainActivity extends BaseActivity {

    private RecyclerView mRvGrid, mRvList;
    private MusicGridAdapter mGridAdapter;
    private MusicListAdapter mListAdapter;
    private RealmHelper mRealmHelper;
    private MusicSourceModel mMusicSourceModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData () {
        mRealmHelper = new RealmHelper();
        mMusicSourceModel = mRealmHelper.getMusicSource();

    }

    private void initView(){
        initNavBar(false,"小天Music",true);

        /*推荐歌单*/
        mRvGrid = findViewById(R.id.rv_grid);
        /*1.上下文，2.一行展示的个数*/
        mRvGrid.setLayoutManager(new GridLayoutManager(this, 3));
        mRvGrid.addItemDecoration(new GridSpaceItemDecoration(getResources().getDimensionPixelOffset(R.dimen.albumMarginSize),mRvGrid));
        mRvGrid.setNestedScrollingEnabled(false);//禁止单独滑动
        mGridAdapter = new MusicGridAdapter(this, mMusicSourceModel.getAlbum());
        mRvGrid.setAdapter(mGridAdapter);

        /**
         * 1、 已知列表高度的情况，可以直接在布局中把RecycleView的高度定义出来
         * 2、 未知列表高度的情况，需要手动计算RecycleView的高度
         */

        /*最热音乐*/
        mRvList = findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(this));
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));/*分割线*/
        mRvList.setNestedScrollingEnabled(false);//禁止单独滑动
        mListAdapter = new MusicListAdapter(this,mRvList, mMusicSourceModel.getHot());
        mRvList.setAdapter(mListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmHelper.close();
    }
}
