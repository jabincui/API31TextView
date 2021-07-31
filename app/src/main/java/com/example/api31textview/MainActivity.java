package com.example.api31textview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.example.api31textview.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    ActivityMainBinding binding;

    TextView allowUndo;
    TextView autoLink;
    TextView autoSize;

    TextView bufferType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setAllowUndo();
        setAutoLink();
        setAutoSize();
        setBufferType();
    }

    /**
     *  TODO：撤销和恢复的方法
     */
    private void setAllowUndo() {
        allowUndo = binding.allowUndo;
    }

    /**
     * setAutoLinkMask
     * <s>这个方法失败了</s>需要在这个方法后面setText才能生效，
     * 并且只有<strong>最后一次</strong>调用的结果会保留
     * （android:text的值不受此方法影响）
     * 似乎xml更好使，但是不可避免的会用这个方法
     */
    private void setAutoLink() {
        autoLink = binding.autoLink;
        autoLink.setAutoLinkMask(Linkify.ALL);
        autoLink.setAutoLinkMask(Linkify.EMAIL_ADDRESSES);
        autoLink.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        autoLink.setText("www.baidu.com||http://www.baidu.com" +
                "||https://www.baidu.com||12312341234||123456@qq.com||");
    }

    /**
     *
     */
    private void setAutoSize() {
        autoSize = binding.autoSize;
//        autoSize.setAutoSizeTextTypeUniformWithConfiguration(
//                30, 80,
//                1, TypedValue.COMPLEX_UNIT_DIP
//        );
//        autoSize.setText("Auto size");
        // getTextSize: in pixels
        Log.d(TAG, "setAutoSize: text size: " + autoSize.getTextSize());
    }


    private void setBufferType() {
        bufferType = binding.bufferType;
        Spannable spannable = new SpannableString("span");
        Editable editable = (Editable) bufferType.getText();
        Log.d(TAG, "setBufferType: editable" + editable);
    }
}