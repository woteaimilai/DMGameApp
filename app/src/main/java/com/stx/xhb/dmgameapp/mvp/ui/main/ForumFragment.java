package com.stx.xhb.dmgameapp.mvp.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.classic.common.MultipleStatusView;
import com.stx.core.base.BaseMvpFragment;
import com.stx.core.utils.NetUtils;
import com.stx.xhb.dmgameapp.R;
import com.stx.xhb.dmgameapp.data.entity.ForumChannelListBean;
import com.stx.xhb.dmgameapp.mvp.contract.GetForumChannelContract;
import com.stx.xhb.dmgameapp.mvp.presenter.GetForumChannelPresenter;
import com.stx.xhb.dmgameapp.mvp.ui.adapter.ForumViewPagerFragmentAdapter;
import com.stx.xhb.dmgameapp.utils.ToastUtil;

import java.util.List;

import butterknife.Bind;

/**
 * 论坛的Fragment
 */
public class ForumFragment extends BaseMvpFragment<GetForumChannelPresenter> implements GetForumChannelContract.getChannelListView {

    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewpager_forum)
    ViewPager mViewPager;
    @Bind(R.id.multiplestatusview)
    MultipleStatusView multiplestatusview;

    public static ForumFragment newInstance() {
        return new ForumFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        initView();
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getChannelList();
    }

    private void initView() {
        mTitle.setText("论坛");
        if (multiplestatusview != null) {
            multiplestatusview.setOnRetryClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lazyLoad();
                }
            });
        }
    }

    //设置适配器
    private void setAdapter(List<ForumChannelListBean.HtmlEntity> channelList) {
        //实例化适配器
        ForumViewPagerFragmentAdapter adapter = new ForumViewPagerFragmentAdapter(getChildFragmentManager(), channelList);
        //设置适配器
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(channelList.size());
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void getChannelSuccess(List<ForumChannelListBean.HtmlEntity> channelList) {
        if (multiplestatusview != null) {
            multiplestatusview.showContent();
        }
        setAdapter(channelList);
    }

    @Override
    public void getChanelFailed(String msg) {
        ToastUtil.show(msg);
        if (multiplestatusview != null) {
            multiplestatusview.showError();
        }
    }

    @Override
    public void showLoading() {
        if (multiplestatusview != null) {
            multiplestatusview.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (multiplestatusview != null) {
            if (!NetUtils.isNetConnected(getActivity())) {
                multiplestatusview.showNoNetwork();
            }
        }
    }

    @NonNull
    @Override
    protected GetForumChannelPresenter onLoadPresenter() {
        return new GetForumChannelPresenter();
    }
}
