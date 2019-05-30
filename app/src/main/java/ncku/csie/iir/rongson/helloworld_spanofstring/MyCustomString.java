/*
 *   _____                 ____
 *  |  _  \__  _ __   ___ /  __\__  _ __
 *  | |_) /  \| '_ \ / _ \\_ \_/  \| '_ \
 *  |  _ ( () | | | [ (_)|__\ ( () | | | |
 *  |_| \_\__/|_| |_|\_  |\____\__/|_| |_|
 *                    _| |
 *                   (___/
 *
 * Created by RongSon on 2019/05/30.
 */

package ncku.csie.iir.rongson.helloworld_spanofstring;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

public class MyCustomString {
    private static MyCustomString instance = null;
    private SpannableString string;
    private TextView text;
    private Context context;

    private MyCustomString(Context context, TextView text, String s){
        string = new SpannableString(s);
        this.context = context;
        this.text = text;
    }

    public static MyCustomString builder(Context context, TextView text, String s){
        if (instance == null){
            instance = new MyCustomString(context, text, s);
        }
        return instance;
    }

    public SpannableString getSpannableString(){
        return string;
    }

    public void commit(){
        text.setText(getSpannableString());
    }

    // background color of span
    public MyCustomString addBackgroundColorSpan(int color, int start, int end){
        string.setSpan(new BackgroundColorSpan(ContextCompat.getColor(context, color)), start, end+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return instance;
    }

    // clickable of span
    // click event of span: also needs setMovementMethod to make onClick work
    public MyCustomString addClickableSpan(ClickableSpan span, int start, int end){
        string.setSpan(span, start, end+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        /*
         * Default color of clickableSpan is R.color.colorAccent, but I want it to be black for default.
         * So, you can comment the line below to check what happens.
         */
        string.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.black)), start, end+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        text.setMovementMethod(LinkMovementMethod.getInstance());
        return instance;
    }

    // enlarge or shrink of span
    public MyCustomString addResizeSpan(float propotion, int start, int end){
        string.setSpan(new RelativeSizeSpan(propotion), start, end+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return instance;
    }

    public MyCustomString addFontColor(int color, int start, int end){
        string.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, color)), start, end+1, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return instance;
    }

}
