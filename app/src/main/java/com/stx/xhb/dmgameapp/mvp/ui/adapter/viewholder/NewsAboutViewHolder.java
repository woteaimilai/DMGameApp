package com.stx.xhb.dmgameapp.mvp.ui.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.stx.core.utils.DateUtils;
import com.stx.xhb.dmgameapp.R;
import com.stx.xhb.dmgameapp.data.entity.NewsAboutBean;
import com.stx.xhb.dmgameapp.data.entity.NewsPageBean;
import com.stx.xhb.dmgameapp.mvp.ui.activity.NewsDetailsActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author：xiaohaibin
 * @time：2017/9/18
 * @emil：xhb_199409@163.com
 * @Github：https://github.com/xiaohaibin/
 * @Describe：
 */

public class NewsAboutViewHolder extends BaseViewHolder<NewsAboutBean.ListBean> {
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.date)
    TextView mDate;
    @Bind(R.id.iv)
    ImageView mIv;
    @Bind(R.id.comment)
    TextView tvComment;

    public NewsAboutViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(final NewsAboutBean.ListBean data) {
        mTitle.setText(data.getTitle());
        tvComment.setText(String.valueOf("评论："+data.getTotal_ct()));
        mDate.setText(DateUtils.getFriendlyTime(data.getPubdate_at()+"000"));
        Glide.with(getContext()).load(data.getLitpic()).into(mIv);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailsActivity.start(getContext(),data.getWebviewurl(),data.getArcurl(),data.getTitle(),data.getLitpic());
            }
        });
    }
}
