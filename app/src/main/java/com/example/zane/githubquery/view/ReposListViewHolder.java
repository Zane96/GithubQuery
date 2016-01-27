package com.example.zane.githubquery.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zane.easymvp.view.BaseListViewHolderImpl;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.model.bean.Repos;


/**
 * Created by Zane on 16/1/27.
 */
public class ReposListViewHolder extends BaseListViewHolderImpl<Repos> {

    private TextView reposItemText;

    public ReposListViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext())
                      .inflate(R.layout.mainactivity_repositem_layout, parent, false));

        initView();
    }

    @Override
    public void initView() {
        reposItemText = $(R.id.repos_item_text);
    }

    @Override
    public void setData(Repos repos) {
        Log.i("ViewHolder", repos.getName()+" gg "+String.valueOf(reposItemText));
        reposItemText.setText(repos.getName());
    }
}
