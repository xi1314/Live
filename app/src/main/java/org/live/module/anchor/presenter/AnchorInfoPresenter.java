package org.live.module.anchor.presenter;

import android.graphics.Bitmap;
import android.net.Uri;

/**
 * 主播信息表示层
 * Created by KAM on 2017/4/22.
 */

public interface AnchorInfoPresenter {
    /**
     * 提交单项主播信息
     */
    public void postAnchorItemInfo(String key, String val);

    /**
     * 上传主播封面图片
     */
    public void postAnchorCoverImg(String filePath);

    /**
     * 裁剪房间封面
     *
     * @param uri
     */
    public void cropRoomCover(Uri uri);

    /**
     * 保存图片至sd卡
     */
    public String setPicToSd(Bitmap bitmap);


    /**
     * 校验输入项
     */
    public boolean validateInputItem(String key, String val);

    /**
     * 检查直播间是否被禁播
     */
    public void checkLiveRoomIsBan();
}
