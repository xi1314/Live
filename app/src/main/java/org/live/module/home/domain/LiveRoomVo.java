package org.live.module.home.domain;


/**
 * 直播间的vo
 * <p>
 * Created by Mr.wang on 2017/4/5.
 */
public class LiveRoomVo {

    /**
     * 直播间id
     */
    private String liveRoomId;

    /**
     * 主播id
     */
    private String anchorId;
    /**
     * 房间号
     */
    private String roomNum;

    /**
     * 直播间封面
     */
    private String liveRoomCoverUrl;

    /**
     * 直播地址
     */
    private String liveRoomUrl;

    /**
     * 直播间名称
     */
    private String liveRoomName;

    /**
     * 主播名称
     */
    private String anchorName;

    /**
     * 头像url
     */
    private String headImgUrl;

    /**
     * 在线人数
     */
    private int onlineCount;

    /**
     * 正在直播的标记
     */
    private boolean liveFlag;

    public LiveRoomVo() {
    }


    public String getLiveRoomId() {
        return liveRoomId;
    }

    public void setLiveRoomId(String liveRoomId) {
        this.liveRoomId = liveRoomId;
    }

    public String getAnchorId() {
        return anchorId;
    }

    public void setAnchorId(String anchorId) {
        this.anchorId = anchorId;
    }

    public String getLiveRoomCoverUrl() {
        return liveRoomCoverUrl;
    }

    public void setLiveRoomCoverUrl(String liveRoomCoverUrl) {
        this.liveRoomCoverUrl = liveRoomCoverUrl;
    }

    public String getLiveRoomName() {
        return liveRoomName;
    }

    public void setLiveRoomName(String liveRoomName) {
        this.liveRoomName = liveRoomName;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public void setAnchorName(String anchorName) {
        this.anchorName = anchorName;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public boolean isLiveFlag() {
        return liveFlag;
    }

    public void setLiveFlag(boolean liveFlag) {
        this.liveFlag = liveFlag;
    }

    public String getLiveRoomUrl() {
        return liveRoomUrl;
    }

    public void setLiveRoomUrl(String liveRoomUrl) {
        this.liveRoomUrl = liveRoomUrl;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
