package com.szhrnet.taoqiapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;

import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.szhrnet.taoqiapp.R;

import java.io.File;

/**
 * Created by Administrator on 2017/12/6.
 */

public class PhotoSelectUtils {

    public static void showDialog(final int limit, final TakePhoto takePhoto, final Context context, final boolean isCrop, final boolean isShowCompressDialog,
                                  final int cropWidth, final int cropHeight) {
        final String items[] = {context.getResources().getString(R.string.pz), context.getResources().getString(R.string.xzzp)};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.ts));
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (items[which].equals(context.getResources().getString(R.string.pz))) {
                    takePhotos(takePhoto, isCrop,cropWidth,cropHeight,isShowCompressDialog);
                } else if (items[which].equals(context.getResources().getString(R.string.xzzp))) {
                    selectPicture(limit, takePhoto, isCrop,cropWidth,cropHeight,isShowCompressDialog);
                }

            }
        });
        builder.setPositiveButton(context.getResources().getString(R.string.qx), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }


    public static void takePhotos(TakePhoto takePhoto, boolean isCrop, int cropWidth, int cropHeight,boolean isShowCompressDialog) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        Uri imageUri = Uri.fromFile(file);
        configCompress(takePhoto,isShowCompressDialog);
        if (isCrop)
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions(cropWidth,cropHeight));
        else
            takePhoto.onPickFromCapture(imageUri);
    }


    public static void configCompress(TakePhoto takePhoto,boolean isShowCompressDialog) {
        int maxSize = (int) (0.5 * 1024);
        int width = 800;
        int height = 800;
        CompressConfig config;
        config = new CompressConfig.Builder()
                .setMaxSize(maxSize)
                .setMaxPixel(width >= height ? width : height)
                .enableReserveRaw(true)
                .create();
        takePhoto.onEnableCompress(config, isShowCompressDialog);//是否显示压缩进度条
    }


    public static CropOptions getCropOptions(int cropWidth, int cropHeight) {
        CropOptions.Builder builder = new CropOptions.Builder();
        builder.setAspectX(cropWidth).setAspectY(cropHeight);
        builder.setWithOwnCrop(false);//是否使用自带剪切工具
        return builder.create();
    }


    public static void selectPicture(int limit, TakePhoto takePhoto, boolean isCrop, int cropWidth, int cropHeight,boolean isShowCompressDialog) {
        configCompress(takePhoto,isShowCompressDialog);
        if (isCrop)
            takePhoto.onPickMultipleWithCrop(limit, getCropOptions(cropWidth,cropHeight));
        else
            takePhoto.onPickMultiple(limit);
    }

}
