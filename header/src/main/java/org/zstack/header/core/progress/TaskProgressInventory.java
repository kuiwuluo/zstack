package org.zstack.header.core.progress;

import org.zstack.header.search.Inventory;
import org.zstack.utils.gson.JSONObjectUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by xing5 on 2017/3/20.
 */
@Inventory(mappingVOClass = TaskProgressVO.class)
public class TaskProgressInventory {
    private String taskUuid;
    private String parentUuid;
    private String type;
    private String content;
    private LinkedHashMap opaque;
    private Long time;

    public static TaskProgressInventory valueOf(TaskProgressVO vo) {
        TaskProgressInventory inv = new TaskProgressInventory();
        inv.setTaskUuid(vo.getTaskUuid());
        inv.setParentUuid(vo.getParentUuid());
        inv.setType(vo.getType().toString());
        inv.setContent(vo.getContent());
        if (vo.getOpaque() != null) {
            inv.setOpaque(JSONObjectUtil.toObject(vo.getOpaque(), LinkedHashMap.class));
        }
        inv.setTime(vo.getTime());
        return inv;
    }

    public static List<TaskProgressInventory> valueOf(Collection<TaskProgressVO> vos) {
        List<TaskProgressInventory> invs = new ArrayList<>();
        for (TaskProgressVO vo : vos) {
            invs.add(valueOf(vo));
        }
        return invs;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LinkedHashMap getOpaque() {
        return opaque;
    }

    public void setOpaque(LinkedHashMap opaque) {
        this.opaque = opaque;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
