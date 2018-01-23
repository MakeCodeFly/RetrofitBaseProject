package com.szhrnet.taoqiapp.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.szhrnet.taoqiapp.utils.AppUtils;
import com.szhrnet.taoqiapp.utils.EventBusModel;
import com.szhrnet.taoqiapp.utils.EventBusUtils;
import com.szhrnet.taoqiapp.utils.ToastUtils;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : BaseFragment类
 *     email:15695947865@139.com
 * </pre>
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private View mContentView = null;
    private long lastClick = 0;

    protected Context mContext;
    protected Unbinder mRootUnBinder;

    protected ToastUtils toastUtils = null;
    protected SVProgressHUD mProgress = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            setContentView(bindLayout());
            mRootUnBinder = ButterKnife.bind(this, mContentView);
            toastUtils = new ToastUtils(mContext);
            mProgress = new SVProgressHUD(mContext);
            EventBusUtils.registerEventBus(this);
            initView(mContentView);
            initWidget(savedInstanceState);
        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return mContentView;
    }

    protected void setContentView(@LayoutRes int layoutResID) {
        mContentView = LayoutInflater.from(mContext).inflate(layoutResID, null);
    }


    /**
     * [绑定布局]
     *
     * @return
     */
    public abstract int bindLayout();

    /**
     * [初始化控件]
     *
     * @param view
     */
    public abstract void initView(final View view);

    /**
     * 处理业务逻辑，状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected abstract void initWidget(Bundle savedInstanceState);


    /** View点击 **/
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        if (fastClick())
            widgetClick(v);
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T $(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    /**
     * [防止快速点击]
     *
     * @return
     */
    private boolean fastClick() {

        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (toastUtils != null)
            toastUtils.cancel();
        AppUtils.dismissSvProgressHud(mProgress);
        EventBusUtils.unRegisterEventBus(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusModel eventBusModel) {}


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String eventType) {}


}