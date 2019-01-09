package com.stx.xhb.dmgameapp.mvp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.stx.xhb.dmgameapp.R;
import com.stx.xhb.dmgameapp.data.entity.CommentListBean;
import com.stx.xhb.dmgameapp.data.entity.CommentsBean;
import com.stx.xhb.dmgameapp.mvp.ui.adapter.viewholder.NewsCommentViewHolder;

/**
 * @author: xiaohaibin.
 * @time: 2018/3/2
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe: 评论列表实体类
 */

public class CommentListAdapter extends RecyclerArrayAdapter<CommentListBean.ListBean> {

    private LayoutInflater mLayoutInflater;

    public CommentListAdapter(Context context) {
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsCommentViewHolder(mLayoutInflater.inflate(R.layout.list_item_comment, parent, false));
    }
}
