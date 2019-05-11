package xtmusic.xiaotian.com.xtmusic.views;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration{

    private int mSpace;

    public  GridSpaceItemDecoration (int space,RecyclerView parent){
        mSpace = space;
        getRecycleViewOffsets(parent);
    }

    /**
     *
     * @param outRect  Item的矩形边界
     * @param view      ItemView
     * @param parent    RecyclerView
     * @param state     RecyclerView状态
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        //距离左侧偏移量
        outRect.left = mSpace;
        //判断Item是否是每一行第一个Item
        //不可行
        /*if (parent.getChildLayoutPosition(view) % 3 == 0){
            outRect.left = 0;
        }*/
    }


    private void getRecycleViewOffsets(RecyclerView parent){

        /*View margin
         * margin 为 正  则View 会距离边界产生一个距离
         * margin 为 负  则View 会超出边界产生一个距离
         * */

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) parent.getLayoutParams();
        layoutParams.leftMargin  = -mSpace;
        parent.setLayoutParams(layoutParams);
    }

}
