package org.zstack.header.core.progress;

import org.zstack.header.message.APIReply;

/**
 * Created by xing5 on 2017/3/21.
 */
public class APIGetTaskProgressReply extends APIReply {
    private TaskProgressInventory inventory;

    public TaskProgressInventory getInventory() {
        return inventory;
    }

    public void setInventory(TaskProgressInventory inventory) {
        this.inventory = inventory;
    }
}
