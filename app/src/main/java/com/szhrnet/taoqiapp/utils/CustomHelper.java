package com.szhrnet.taoqiapp.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;


import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.LubanOptions;
import com.jph.takephoto.model.TakePhotoOptions;
import com.szhrnet.taoqiapp.R;
import com.szhrnet.taoqiapp.widget.customdialog.ActionSheetDialog;

import java.io.File;


public class CustomHelper {

    public static CustomHelper of() {
        return new CustomHelper();
    }

    private static boolean isCrop;//是否裁切
    private static boolean isCropTool;//裁切工具是否自带  true
    private static boolean isCropSizeAspect;//裁切图片是否是比例 true  宽/高   false  宽x高

    private static boolean isCompress;//是否压缩
    private static boolean isCompressTool;//压缩工具是否自带  true
    private static boolean isShowProgressBar;//是否显示压缩进度条
    private static boolean isRawFile;//拍照压缩后是否保存原图
    private static int maxSize =(int) (0.5 * 1024);
    private static int cropHeight;
    private static int cropWidth;
    private static int limitNumber;

    private CustomHelper() {
    }

    public static void showDialog(final Context context, final TakePhoto takePhoto) {
        new ActionSheetDialog(context)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem(context.getResources().getString(R.string.pz),
                        ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                takePhotoMethod(takePhoto);

                            }
                        })
                .addSheetItem(context.getResources().getString(R.string.xzzp),
                        ActionSheetDialog.SheetItemColor.Blue,
                        new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                pickPhoto(takePhoto);

                            }
                        }).show();
    }

    public static void pickPhoto(TakePhoto takePhoto) {
        Uri imageUri = setParams(takePhoto);
        if (limitNumber > 1) {
            if (isCrop) {
                takePhoto.onPickMultipleWithCrop(limitNumber, getCropOptions());
            } else {
                takePhoto.onPickMultiple(limitNumber);
            }
            return;
        }

        if (isCrop) {
            takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
        } else {
            takePhoto.onPickFromGallery();
        }
    }

    public static void takePhotoMethod(TakePhoto takePhoto) {
        Uri imageUri = setParams(takePhoto);
        if (isCrop) {
            takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
        } else {
            takePhoto.onPickFromCapture(imageUri);
        }
    }

    private static Uri setParams(TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        final Uri imageUri = Uri.fromFile(file);

        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        return imageUri;

    }


    private static void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        builder.setWithOwnGallery(true);
        builder.setCorrectImage(true);
        takePhoto.setTakePhotoOptions(builder.create());

    }

    private static void configCompress(TakePhoto takePhoto) {
        if (isCompress) {
            takePhoto.onEnableCompress(null, false);
            return;
        }
        CompressConfig config;
        if (isCompressTool) {
            config = new CompressConfig.Builder().setMaxSize(maxSize)
                    .setMaxPixel(cropWidth >= cropHeight ? cropWidth : cropHeight)
                    .enableReserveRaw(isRawFile)
                    .create();
        } else {
            LubanOptions option = new LubanOptions.Builder().setMaxHeight(cropHeight).setMaxWidth(cropWidth).setMaxSize(maxSize).create();
            config = CompressConfig.ofLuban(option);
            config.enableReserveRaw(isRawFile);
        }
        takePhoto.onEnableCompress(config, isShowProgressBar);


    }

    private static CropOptions getCropOptions() {
        if (!isCrop) {
            return null;
        }
        CropOptions.Builder builder = new CropOptions.Builder();

        if (isCropSizeAspect) {
            builder.setAspectX(cropWidth).setAspectY(cropHeight);
        } else {
            builder.setOutputX(cropWidth).setOutputY(cropHeight);
        }
        builder.setWithOwnCrop(isCropTool);
        return builder.create();
    }

    public boolean getIsCrop() {
        return isCrop;
    }

    public void setIsCrop(boolean crop) {
        isCrop = crop;
    }

    public boolean getIsCropTool() {
        return isCropTool;
    }

    public void setIsCropTool(boolean cropTool) {
        isCropTool = cropTool;
    }

    public boolean getIsCropSizeAspect() {
        return isCropSizeAspect;
    }

    public void setIsCropSizeAspect(boolean cropSizeAspect) {
        isCropSizeAspect = cropSizeAspect;
    }

    public boolean getIsCompressTool() {
        return isCompressTool;
    }

    public void setIsCompressTool(boolean compressTool) {
        isCompressTool = compressTool;
    }

    public boolean getIsCompress() {
        return isCompress;
    }

    public void setIsCompress(boolean compress) {
        isCompress = compress;
    }

    public boolean getIsShowProgressBar() {
        return isShowProgressBar;
    }

    public void setIsShowProgressBar(boolean showProgressBar) {
        isShowProgressBar = showProgressBar;
    }

    public boolean getIsRawFile() {
        return isRawFile;
    }

    public void setIsRawFile(boolean rawFile) {
        isRawFile = rawFile;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getCropHeight() {
        return cropHeight;
    }

    public void setCropHeight(int cropHeight) {
        this.cropHeight = cropHeight;
    }

    public int getCropWidth() {
        return cropWidth;
    }

    public void setCropWidth(int cropWidth) {
        this.cropWidth = cropWidth;
    }

    public int getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(int limitNumber) {
        this.limitNumber = limitNumber;
    }
}
