package com.szhrnet.taoqiapp.view.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;
import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.base.BaseFragment;
import com.szhrnet.taoqiapp.utils.GlideUtils;
import com.szhrnet.taoqiapp.utils.PhotoSelectUtils;

import butterknife.BindView;


/**
 * <pre>
 *     author: MakeCodeFly
 *     email:15695947865@139.com
 * </pre>
 */
public class MineFragment  extends BaseFragment implements View.OnClickListener, TakePhoto.TakeResultListener, InvokeListener {
    @BindView(R.id.fm_tv_select)
    TextView textView;

    @BindView(R.id.fm_iv_logo)
    ImageView mIvLogo;

    @Override
    public int bindLayout() {
        return R.layout.fragment_mine;
    }


    @Override
    public void initView(View view) {
        textView.setOnClickListener(this);
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.fm_tv_select:
                PhotoSelectUtils.showDialog(1, takePhoto, mContext, true,false,800,800);
                break;
        }
    }



    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult((Activity) mContext, type, invokeParam, this);
    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */
    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    public void takeSuccess(TResult result) {
        GlideUtils.loadCustomerViewHolder((Activity) mContext, result.getImage().getOriginalPath(), mIvLogo);
    }

    @Override
    public void takeFail(TResult result, String msg) {
    }

    @Override
    public void takeCancel() {
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

}
