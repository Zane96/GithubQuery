package com.example.zane.githubquery.view;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zane.easymvp.view.BaseViewImpl;
import com.example.zane.githubquery.R;

import butterknife.Bind;

/**
 * Created by Zane on 16/1/27.
 */
public class MainView extends BaseViewImpl {

    @Bind(R.id.texiview)
    TextView texiview;
    @Bind(R.id.edittext)
    EditText edittext;
    @Bind(R.id.button_query)
    Button buttonQuery;

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    public String getEditText(){
        Log.i("MainView", edittext+"heihei");
        return edittext.getText().toString();
    }
}
