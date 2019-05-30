# MyCustomString
It's a simple library for using Spans of android.

## Introduction
Does span bother you? Creating a lot of span's object is chaos? <p></p>
Try to use MyCustomString to get rid of it.

## ScreenShots
<img src="https://github.com/shrimp509/MyCustomString/blob/master/screenshots/1.png" height=400>

## Why MyCustomString?
* Without MyCustomString:
``` java
// Declare
TextView text = findViewById(R.id.main_text);
String originString = "Hello, My Friends";
SpannableString string = new SpannableString(originString);

// set BackgroundColor
BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
string.setSpan(backgroundColorSpan, 0, string.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

// set FontColor
ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(MainActivity.this, R.color.white));
string.setSpan(foregroundColorSpan, 0, 5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

// set Clickable event
ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
          Toast.makeText(this, "click: " + ++count, Toast.LENGTH_SHORT).show();
        }
    }
st.setSpan(clickableSpan, 0, string.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);

// set Text
text.setText(string);
```

* With MyCustomString:
```java
// Declare
TextView text = findViewById(R.id.main_text);
String originString = "Hello, My Friends";

// set all whatever you want in one place
MyCustomString.builder(MainActivity.this, text, originString)
    .addBackgroundColorSpan(R.color.colorAccent, originString.indexOf("H"), originString.indexOf("s"))
    .addFontColor(R.color.white, 0, 5)
    .addClickableSpan(new ClickableSpan() {
        @Override
        public void onClick(View widget) {
          Toast.makeText(MainActivity.this, "click: " + ++count, Toast.LENGTH_SHORT).show();
        }
     }, originString.indexOf("M"), originString.indexOf("s"))
    .commit();
```

## Support
  * addBackgroundColorSpan
  * addFontColor
  * addClickableSpan
  * addResizeSpan
  * ...
  * and you can add whatever span you want by yourself
