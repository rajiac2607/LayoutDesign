package in.raji.goldenscent.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import in.raji.goldenscent.R;

/**
 * Created by Raji on 12/10/2018.
 */
public class ItemDecorator extends RecyclerView.ItemDecoration {
    private final Drawable mDivider;

    public ItemDecorator(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.recycler_divider);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount-1; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left+Utility.convertDp_to_Px(parent.getContext(),50), top, right+16, bottom);
            mDivider.draw(c);
        }
    }
}

