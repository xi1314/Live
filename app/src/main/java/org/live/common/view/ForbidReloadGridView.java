package org.live.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 有效解决gridview在初始化的重复加载gridview中的item
 *
 * 在适配器中的getView时，判断measureExecute的标记，true的话，就直接返回view，不用去设置属性
 * Created by Mr.wang on 2017/4/4.
 */

public class ForbidReloadGridView extends GridView {

    /**
     * onMeasure方法执行的标记
     */
    protected boolean measureExecute = true ;

    public ForbidReloadGridView(Context context) {
        super(context);
    }

    public ForbidReloadGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureExecute = true;
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        measureExecute = false;
        super.onLayout(changed, l, t, r, b);
    }

    public boolean isMeasureExecute() {
        return measureExecute;
    }

}
