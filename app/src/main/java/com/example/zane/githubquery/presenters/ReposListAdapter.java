package com.example.zane.githubquery.presenters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.zane.easymvp.presenter.BaseListAdapterPresenter;
import com.example.zane.easymvp.view.BaseListViewHolderImpl;
import com.example.zane.githubquery.model.bean.Repos;
import com.example.zane.githubquery.view.ReposListViewHolder;

import java.util.List;

/**
 * Created by Zane on 16/1/27.
 */
public class ReposListAdapter extends BaseListAdapterPresenter<Repos>{

    public ReposListAdapter(Context context, List<Repos> datas){
        super(context, datas);
    }

    @Override
    public BaseListViewHolderImpl OnCreatViewHolder(ViewGroup viewGroup, int i) {

        return new ReposListViewHolder(viewGroup);

    }

    @Override
    public void onBindViewHolder(BaseListViewHolderImpl holder, int position) {
        holder.setData(getItem(position));
    }
}
