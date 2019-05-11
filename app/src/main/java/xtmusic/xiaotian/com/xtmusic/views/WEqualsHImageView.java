package xtmusic.xiaotian.com.xtmusic.views;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class WEqualsHImageView extends AppCompatImageView {
    public WEqualsHImageView(Context context) {
        super(context);
    }

    public WEqualsHImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WEqualsHImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //让宽高相同
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);

        /*获取宽度*/
       /* int width = MeasureSpec.getSize(widthMeasureSpec);*/
        /*获取模式
        * match_parent、warp_content、具体dp
        * */
        /*int mode = MeasureSpec.getMode(widthMeasureSpec);*/
    }
}
