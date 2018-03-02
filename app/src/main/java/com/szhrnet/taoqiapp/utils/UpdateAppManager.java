package com.szhrnet.taoqiapp.utils;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : UpdateAPPManager版本更新管理（支持后台下载）
 *     email:15695947865@139.com
 * </pre>
 */
/**
 * <pre>
 *     author: MakeCodeFly
 *     desc  : UpdateAPPManager版本更新管理（支持后台下载）
 *     email:15695947865@139.com
 * </pre>
 */
@SuppressWarnings("unused")
public class UpdateAppManager {


    public final static String SAVE_APP_NAME = "retrofitbaseproject";

    public static String fileApkName = "";

    public static DownloadManager mDownloadManager;
    public static long downloadId;

    public static Context context2;

    /**
     * 显示软件下载对话框
     */
    /**
     * 下载Apk, 并设置Apk地址,
     * 默认位置: /storage/sdcard0/Download
     *
     * @param context    上下文
     * @param downLoadUrl 下载地址
     * @param infoName   通知名称
     * @param description  通知描述
     */
    @SuppressWarnings("unused")
    public static void  showDownloadDialog( Context context,
                                            String downLoadUrl,
                                            String description,
                                            String infoName,String version) {
        context2 = context;
        //使用系统下载类
        mDownloadManager = (DownloadManager) context2.getSystemService(DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(downLoadUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setAllowedOverRoaming(false);
        fileApkName = (String) TextUtils.concat(SAVE_APP_NAME,version,".apk");

        //创建目录下载
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileApkName);
        // 把id保存好，在接收者里面要用
        downloadId = mDownloadManager.enqueue(request);
        //设置允许使用的网络类型，这里是移动网络和wifi都可以
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE |
                DownloadManager.Request.NETWORK_WIFI);
        //机型适配
        request.setMimeType("application/vnd.android.package-archive");
        //通知栏显示
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setTitle(infoName);
        request.setDescription(description);
        request.setVisibleInDownloadsUi(true);
        context2.registerReceiver(mReceiver, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }




    public static BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkStatus();
        }
    };

    /**
     * 检查下载状态
     */
    public static void checkStatus() {
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        Cursor cursor = mDownloadManager.query(query);
        if (cursor.moveToFirst()) {
            int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
            switch (status) {
                //下载暂停
                case DownloadManager.STATUS_PAUSED:
                    break;
                //下载延迟
                case DownloadManager.STATUS_PENDING:
                    break;
                //正在下载
                case DownloadManager.STATUS_RUNNING:
                    break;
                //下载完成
                case DownloadManager.STATUS_SUCCESSFUL:
                    installAPK();
                    break;
                //下载失败
                case DownloadManager.STATUS_FAILED:
                    Toast.makeText(context2, "下载失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        cursor.close();
    }

    /**
     * 7.0兼容
     */
    public static void installAPK() {
        File apkFile =
                new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileApkName);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri apkUri = FileProvider.getUriForFile(context2, context2.getPackageName() + ".fileprovider", apkFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        context2.startActivity(intent);
    }


}