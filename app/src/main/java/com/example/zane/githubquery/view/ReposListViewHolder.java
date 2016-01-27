package com.example.zane.githubquery.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zane.easymvp.view.BaseListViewHolderImpl;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.model.bean.Repos;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Zane on 16/1/27.
 */
public class ReposListViewHolder extends BaseListViewHolderImpl<Repos> {

    @Bind(R.id.repos_item_text)
    TextView reposItemText;

    private View v;

    public ReposListViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext())
                      .inflate(R.layout.mainactivity_repositem_layout, parent, false));
        v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mainactivity_repositem_layout, parent, false);
    }

    @Override
    public void initView() {
        ButterKnife.bind(this, v);
    }

    @Override
    public void setData(Repos repos) {
        reposItemText.setText(repos.getName());
    }
}
