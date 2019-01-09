package com.stx.xhb.dmgameapp.mvp.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.stx.xhb.dmgameapp.R;
import com.stx.xhb.dmgameapp.data.entity.CommentListBean;
import com.stx.xhb.dmgameapp.data.entity.CommentsBean;
import com.stx.xhb.dmgameapp.data.entity.NewsAboutBean;
import com.stx.xhb.dmgameapp.data.entity.NewsPageBean;
import com.stx.xhb.dmgameapp.mvp.ui.adapter.viewholder.NewsCommentViewHolder;

import java.util.List;

/**
 * @author: xiaohaibin.
 * @time: 2018/2/28
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe:
 */

public class NewsDetailsAdapter extends RecyclerArrayAdapter<CommentListBean.ListBean> {

    private String mUrl;
    private List<NewsAboutBean.ListBean> mDataList;
    private LayoutInflater mLayoutInflater;

    public NewsDetailsAdapter(Context context) {
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsCommentViewHolder(mLayoutInflater.inflate(R.layout.list_item_comment, parent, false));
    }

    public void setWebData(String url) {
        this.mUrl = url;
        if (!TextUtils.isEmpty(url)) {
            addHeader(new ItemView() {
                @Override
                public View onCreateView(ViewGroup parent) {
                    WebView mWebView = new WebView(getContext());
                    mWebView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    WebSettings settings = mWebView.getSettings();
                    settings.setDefaultTextEncodingName("utf-8");
                    settings.setJavaScriptEnabled(true);
                    settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //设置缓存
                    settings.setAppCacheEnabled(true);
                    settings.setSupportZoom(true);
                    settings.setBuiltInZoomControls(true);
                    settings.setUseWideViewPort(true);
                    settings.setLoadWithOverviewMode(true);
                    //不显示webview缩放按钮
                    settings.setDisplayZoomControls(false);
                    // 解决HTTPS协议下出现的mixed content问题
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
                    }
                    settings.setDomStorageEnabled(true);
                    settings.setDatabaseEnabled(true);
                    settings.setGeolocationEnabled(true);
                    mWebView.loadUrl(mUrl);
                    return mWebView;
                }

                @Override
                public void onBindView(View headerView) {
                }
            });
        }
    }


    public void addNewList(List<NewsAboutBean.ListBean> dataList) {
        this.mDataList = dataList;
        if (mDataList != null && !mDataList.isEmpty()) {
            addHeader(new ItemView() {

                @Override
                public View onCreateView(ViewGroup parent) {
                    EasyRecyclerView recyclerView = new EasyRecyclerView(getContext());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.getRecyclerView().setNestedScrollingEnabled(false);
                    NewsAboutAdapter adapter = new NewsAboutAdapter(getContext());
                    adapter.addAll(mDataList);
                    recyclerView.setAdapter(adapter);
                    return recyclerView;
                }

                @Override
                public void onBindView(View headerView) {
                    ((ViewGroup) headerView).requestDisallowInterceptTouchEvent(true);
                }
            });
        }
    }

    public void addListLabel(final String title) {
        addHeader(new ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return mLayoutInflater.inflate(R.layout.layout_news_comment_label, parent, false);
            }

            @Override
            public void onBindView(View headerView) {
                if (headerView != null) {
                    TextView tvTitle = (TextView) headerView.findViewById(R.id.tv_title);
                    tvTitle.setText(title);
                }
            }
        });
    }

    public void addEmptyCommentFooter() {
        removeAllFooter();
        addFooter(new ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return mLayoutInflater.inflate(R.layout.layout_empty_comments_footer, parent, false);
            }

            @Override
            public void onBindView(View headerView) {
            }
        });
    }


    public void addMoreCommentFooter() {
        removeAllFooter();
        addFooter(new ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                return mLayoutInflater.inflate(R.layout.layout_comments_more_footer, parent, false);
            }

            @Override
            public void onBindView(View headerView) {
                headerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                           if (mOnClickMoreCommentListener!=null){
                               mOnClickMoreCommentListener.onClick();
                           }
                    }
                });
            }
        });
    }

    public OnClickMoreCommentListener mOnClickMoreCommentListener;

    public void setOnClickMoreCommentListener(OnClickMoreCommentListener onClickMoreCommentListener) {
        mOnClickMoreCommentListener = onClickMoreCommentListener;
    }

    public interface OnClickMoreCommentListener {
        void onClick();
    }
}
