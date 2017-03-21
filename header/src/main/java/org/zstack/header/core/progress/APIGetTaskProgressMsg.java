package org.zstack.header.core.progress;

import org.zstack.header.message.APISyncCallMessage;

/**
 * Created by xing5 on 2017/3/21.
 */
public class APIGetTaskProgressMsg extends APISyncCallMessage {
    private String apiId;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
}
