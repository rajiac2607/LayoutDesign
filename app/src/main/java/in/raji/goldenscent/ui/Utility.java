package in.raji.goldenscent.ui;

import android.content.Context;

/**
 * Created by Raji on 12/10/2018.
 */
public class Utility {
    public static int convertDp_to_Px(Context context,float dp ){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
