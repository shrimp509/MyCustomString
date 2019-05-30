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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.main_text);

        // original string we want to show
        String originString = "Hello, My Friends";

        // set whatever styles you want
        MyCustomString.builder(this, text, originString)
                .addBackgroundColorSpan(R.color.colorAccent, originString.indexOf("H"), originString.indexOf("o"))
                .addBackgroundColorSpan(R.color.colorPrimary, originString.indexOf("F"), originString.indexOf("s"))
                .addClickableSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(MainActivity.this, "click: " + ++count, Toast.LENGTH_SHORT).show();
                    }
                }, originString.indexOf("M"), originString.indexOf("s"))
                .addFontColor(R.color.white, originString.indexOf("H"),originString.indexOf("o"))
                .addResizeSpan(1.5f, originString.indexOf("F"), originString.indexOf("s"))
                .commit();
    }

}
