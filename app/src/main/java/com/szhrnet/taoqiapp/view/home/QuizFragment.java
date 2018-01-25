package com.szhrnet.taoqiapp.view.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.base.BaseFragment;
import com.szhrnet.taoqiapp.widget.customdialog.ActionSheetDialog;
import com.szhrnet.taoqiapp.widget.customdialog.CustomAlertDialog;

import butterknife.BindView;


/**
 * <pre>
 *     author: Zou Juequn
 *     desc  : 竞猜Fragment
 *     email:15695947865@139.com
 */
public class QuizFragment extends BaseFragment {
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;

    @Override
    public int bindLayout() {
        return R.layout.fragment_quiz;
    }

    @Override
    public void initView(View view) {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    protected void initWidget(Bundle savedInstanceState) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                new ActionSheetDialog(mContext)
                        .builder()
                        .setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("清空消息列表", ActionSheetDialog.SheetItemColor.Red
                                , new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                }).show();
                break;
            case R.id.btn2:
                new ActionSheetDialog(mContext)
                        .builder()
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("发送给好友",
                                ActionSheetDialog.SheetItemColor.Blue,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                })
                        .addSheetItem("转载到空间相册",
                                ActionSheetDialog.SheetItemColor.Blue,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                })
                        .addSheetItem("上传到群相册",
                                ActionSheetDialog.SheetItemColor.Blue,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                })
                        .addSheetItem("保存到手机",
                                ActionSheetDialog.SheetItemColor.Blue,
                                new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                }).show();
                break;
            case R.id.btn3:
                new ActionSheetDialog(mContext)
                        .builder()
                        .setTitle("好友列表")
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("删除好友", ActionSheetDialog.SheetItemColor.Red
                                , new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                })
                        .addSheetItem("增加好友", ActionSheetDialog.SheetItemColor.Blue
                                , new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                })
                        .addSheetItem("备注", ActionSheetDialog.SheetItemColor.Blue
                                , new ActionSheetDialog.OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {
                                        //填写事件
                                    }
                                }).show();
                break;
            case R.id.btn4:
                new CustomAlertDialog(mContext)
                        .builder()
                        .setTitle("退出当前帐号")
                        .setMsg("再连续登陆天，就可变身为QQ达人。退出QQ可能会使你现有记录归零，确定退出？")
                        .setPositiveButton("确认退出", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //填写事件
                            }
                        })
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //填写事件
                            }
                        }).show();
                break;
            case R.id.btn5:
                new CustomAlertDialog(mContext)
                        .builder()
                        .setTitle("错误信息")
                        .setMsg("你的手机sd卡出现问题，建议删除不需要的文件，否则收不到图片和视频等大文件")
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //填写事件
                            }
                        }).show();
                break;
        }
    }
}
