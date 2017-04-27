package org.live.common.provider;

import org.live.module.login.domain.MobileUserVo;
import org.live.module.play.domain.LiveRoomInfo;

/**
 * 主播信息提供者
 * Created by KAM on 2017/4/26.
 */

public interface AnchorInfoProvider {
    /**
     * 取得主播信息
     */
    public MobileUserVo getAnchorInfo();

    /**
     * 取得直播间信息
     *
     * @return
     */
    public LiveRoomInfo getLiveRoomInfo();

}
