package com.example.zane.githubquery.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.zane.easymvp.view.BaseViewImpl;
import com.example.zane.githubquery.R;
import com.example.zane.githubquery.presenters.ReposListAdapter;

import butterknife.Bind;

/**
 * Created by Zane on 16/1/27.
 */
public class ReposView extends BaseViewImpl {

    @Bind(R.id.recycleview)
    RecyclerView recycleview;

    @Override
    public int getRootViewId() {
        return R.layout.activity_repos_layout;
    }

    public void initRecycleView(LinearLayoutManager manager, ReposListAdapter adapter) {
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(manager);
    }
}
