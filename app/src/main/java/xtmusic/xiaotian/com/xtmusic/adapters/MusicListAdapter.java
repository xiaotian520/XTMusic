package xtmusic.xiaotian.com.xtmusic.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xtmusic.xiaotian.com.xtmusic.R;
import xtmusic.xiaotian.com.xtmusic.activities.PlayMusicActivity;
import xtmusic.xiaotian.com.xtmusic.models.MusicModel;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolder> {

    private Context mContext;
    private View mItemView;
    private RecyclerView mRv;
    private boolean isCalcaulationRvHeight;
    private List<MusicModel> mDataSource;

    public MusicListAdapter (Context context, RecyclerView recyclerView, List<MusicModel> dataSource) {
        mContext = context;
        mRv = recyclerView;
        this.mDataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mItemView = LayoutInflater.from(mContext).inflate(R.layout.item_list_music, viewGroup, false);
        return new ViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        setRecyclerViewHeight();

        final MusicModel musicModel = mDataSource.get(i);

        Glide.with(mContext)
                .load(musicModel.getPoster())
                .into(viewHolder.ivIcon);

        viewHolder.tvName.setText(musicModel.getName());
        viewHolder.tvAuthor.setText(musicModel.getAuthor());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PlayMusicActivity.class);
                intent.putExtra(PlayMusicActivity.MUSIC_ID, musicModel.getMusicId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();//条数
    }

    /**
     * 1、 获取ItemView的高度
     * 2、 获取ItemView的数量
     * 3、 ItemViewHeight * ItemViewNum = RecyclerViewHeight
     */
    private void setRecyclerViewHeight(){

        if (isCalcaulationRvHeight || mRv == null){
            return;
        }
        isCalcaulationRvHeight = true;

        /*获取ItemView的高度*/
        RecyclerView.LayoutParams  itemViewLp = (RecyclerView.LayoutParams) mItemView.getLayoutParams();
        /*获取ItemView的数量*/
        int itemCount = getItemCount();
        /*ItemViewHeight * ItemViewNum = RecyclerViewHeight*/
        int recyclerViewHeight =  itemViewLp.height * itemCount;
        /*设置RecyclerView的高度*/
        LinearLayout.LayoutParams  rvLp = (LinearLayout.LayoutParams) mRv.getLayoutParams();
        rvLp.height = recyclerViewHeight;
        mRv.setLayoutParams(rvLp);

    }


    class ViewHolder extends RecyclerView.ViewHolder{

        View itemView;
        ImageView ivIcon;
        TextView tvName, tvAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.itemView = itemView;
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAuthor = itemView.findViewById(R.id.tv_author);
        }


    }
}
