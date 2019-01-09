package com.stx.xhb.dmgameapp.data.remote;

import android.util.Log;

import com.stx.xhb.dmgameapp.config.ApiService;
import com.stx.xhb.dmgameapp.data.body.FindPwdContent;
import com.stx.xhb.dmgameapp.data.body.GetHotCommentContent;
import com.stx.xhb.dmgameapp.data.body.LoginContent;
import com.stx.xhb.dmgameapp.data.body.NewsAboutContent;
import com.stx.xhb.dmgameapp.data.body.RegisterContent;
import com.stx.xhb.dmgameapp.data.body.SendSmsContent;
import com.stx.xhb.dmgameapp.data.callback.LoadTaskCallback;
import com.stx.xhb.dmgameapp.data.entity.CommentListBean;
import com.stx.xhb.dmgameapp.data.body.GameClassifyContent;
import com.stx.xhb.dmgameapp.data.body.GameContent;
import com.stx.xhb.dmgameapp.data.entity.GameListBean;
import com.stx.xhb.dmgameapp.data.entity.GameRankBean;
import com.stx.xhb.dmgameapp.data.body.GameRankContent;
import com.stx.xhb.dmgameapp.data.entity.NewsAboutBean;
import com.stx.xhb.dmgameapp.data.entity.SaleGameBean;
import com.stx.xhb.dmgameapp.data.entity.UserInfoBean;
import com.stx.xhb.dmgameapp.http.BaseResponse;
import com.stx.xhb.dmgameapp.http.HttpResultSubscriber;
import com.stx.xhb.dmgameapp.utils.RequestBodyHelper;
import com.stx.xhb.dmgameapp.data.TasksDataSource;
import com.stx.xhb.dmgameapp.data.body.NewsContent;
import com.stx.xhb.dmgameapp.data.entity.NewsPageBean;
import com.stx.xhb.dmgameapp.http.HttpManager;
import com.stx.xhb.dmgameapp.http.HttpResult;
import com.stx.xhb.dmgameapp.http.TransformUtils;

import rx.Subscription;

/**
 * Author: Mr.xiao on 2018/9/5
 * @mail:xhb_199409@163.com
 * @github:https://github.com/xiaohaibin
 * @describe: 数据仓库代理类，用于封装从不同来源处获取数据
 */
public class TasksRepositoryProxy implements TasksDataSource {

    private static TasksRepositoryProxy INSTANCE = null;

    private TasksRepositoryProxy() {
    }

    public static TasksRepositoryProxy getInstance() {
        if (INSTANCE == null) {
            synchronized (TasksRepositoryProxy.class) {
                if (INSTANCE == null) {
                    return new TasksRepositoryProxy();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void release() {
        INSTANCE = null;
    }

    @Override
    public Subscription getHowNews(int currentPage, final LoadTaskCallback<NewsPageBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getHotNews(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<NewsPageBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsPageBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsPageBean newsPageBean) {
                        callback.onTaskLoaded(newsPageBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getNews(int currentPage, final LoadTaskCallback<NewsPageBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getNews(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<NewsPageBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsPageBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsPageBean newsPageBean) {
                        callback.onTaskLoaded(newsPageBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getOriginalPage(int currentPage, final LoadTaskCallback<NewsPageBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getOriginalPage(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<NewsPageBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsPageBean>() {

                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsPageBean newsPageBean) {
                        callback.onTaskLoaded(newsPageBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getVideoPage(int currentPage, final LoadTaskCallback<NewsPageBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getVideoPage(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<NewsPageBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsPageBean>() {

                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsPageBean newsPageBean) {
                        callback.onTaskLoaded(newsPageBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getAmusePage(int currentPage, final LoadTaskCallback<NewsPageBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getAmusePage(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<NewsPageBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsPageBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsPageBean newsPageBean) {
                        callback.onTaskLoaded(newsPageBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getHotGame(final LoadTaskCallback<GameListBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getHotGame(RequestBodyHelper.creatRequestBody(new GameContent()))
                .compose(TransformUtils.<HttpResult<GameListBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<GameListBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(GameListBean gameListBean) {
                        callback.onTaskLoaded(gameListBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getSaleGame(int currentPage, final LoadTaskCallback<SaleGameBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getGameSale(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<SaleGameBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<SaleGameBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(SaleGameBean saleGameBean) {
                        callback.onTaskLoaded(saleGameBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getUnSaleGame(int currentPage, final LoadTaskCallback<SaleGameBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getGameUnSale(RequestBodyHelper.creatRequestBody(new NewsContent(currentPage)))
                .compose(TransformUtils.<HttpResult<SaleGameBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<SaleGameBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(SaleGameBean saleGameBean) {
                        callback.onTaskLoaded(saleGameBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }


    @Override
    public Subscription getChinesizeGame(int currentPage, int order, final LoadTaskCallback<SaleGameBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getGameChinese(RequestBodyHelper.creatRequestBody(new GameClassifyContent(currentPage, order)))
                .compose(TransformUtils.<HttpResult<SaleGameBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<SaleGameBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(SaleGameBean saleGameBean) {
                        callback.onTaskLoaded(saleGameBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getRankGame(int currentPage, String uid, final LoadTaskCallback<GameRankBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getGameRank(RequestBodyHelper.creatRequestBody(new GameRankContent(currentPage, uid)))
                .compose(TransformUtils.<HttpResult<GameRankBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<GameRankBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(GameRankBean gameRankBean) {
                        callback.onTaskLoaded(gameRankBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getNewsAbout(String url, final LoadTaskCallback<NewsAboutBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getNewsAbout(RequestBodyHelper.creatRequestBody(new NewsAboutContent(url)))
                .compose(TransformUtils.<HttpResult<NewsAboutBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<NewsAboutBean>() {

                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(NewsAboutBean newsAboutBean) {
                        callback.onTaskLoaded(newsAboutBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription getHotComment(int currentPage, String arcurl, int uid, final LoadTaskCallback<CommentListBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getHotComment(RequestBodyHelper.creatRequestBody(new GetHotCommentContent(currentPage, arcurl, uid)))
                .compose(TransformUtils.<HttpResult<CommentListBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<CommentListBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(CommentListBean commentListBean) {
                        callback.onTaskLoaded(commentListBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }


    @Override
    public Subscription getComment(int currentPage, String arcurl, int uid, final LoadTaskCallback<CommentListBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .getComment(RequestBodyHelper.creatRequestBody(new GetHotCommentContent(currentPage, arcurl, uid)))
                .compose(TransformUtils.<HttpResult<CommentListBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<CommentListBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(CommentListBean commentListBean) {
                        callback.onTaskLoaded(commentListBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription login(String usrname, String pwd, final LoadTaskCallback<UserInfoBean> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .login(RequestBodyHelper.creatRequestBody(new LoginContent(usrname, pwd)))
                .compose(TransformUtils.<HttpResult<UserInfoBean>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<UserInfoBean>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(UserInfoBean userInfoBean) {
                        callback.onTaskLoaded(userInfoBean);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription register(String mobile, String passwd, String validate, final LoadTaskCallback<String> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .register(RequestBodyHelper.creatRequestBody(new RegisterContent(mobile, passwd, validate)))
                .compose(TransformUtils.<HttpResult<String>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<String>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(String baseResponse) {
                        callback.onTaskLoaded(baseResponse);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription sendSms(String mobile, int act, int uid, final LoadTaskCallback<String> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .sendSMS(RequestBodyHelper.creatRequestBody(new SendSmsContent(mobile, act, uid)))
                .compose(TransformUtils.<HttpResult<String>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<String>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(String baseResponse) {
                        callback.onTaskLoaded(baseResponse);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }

    @Override
    public Subscription findPwd(String mobile, String validate, String passwd, final LoadTaskCallback<String> callback) {
        return HttpManager.getInstance().createService(ApiService.class)
                .findPwd(RequestBodyHelper.creatRequestBody(new FindPwdContent(mobile, validate, passwd)))
                .compose(TransformUtils.<HttpResult<String>>defaultSchedulers())
                .subscribe(new HttpResultSubscriber<String>() {
                    @Override
                    public void onStart() {
                        callback.onStart();
                    }

                    @Override
                    public void onSuccess(String baseResponse) {
                        callback.onTaskLoaded(baseResponse);
                    }

                    @Override
                    public void onError(String msg, int code) {
                        callback.onDataNotAvailable(msg);
                    }

                    @Override
                    public void onFinished() {
                        callback.onCompleted();
                    }
                });
    }
}
