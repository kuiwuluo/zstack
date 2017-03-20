package org.zstack.header.core.progress;

import javax.persistence.*;

/**
 * Created by xing5 on 2017/3/20.
 */
@Table
@Entity
public class TaskProgressVO {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column
    private String taskUuid;
    @Column
    private String taskName;
    @Column
    private String parentUuid;
    @Column
    private String subTaskUuid;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskType type;
    @Column
    private String content;
    @Column
    private String arguments;
    @Column
    private String opaque;
    @Column
    private long time;

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskUuid() {
        return taskUuid;
    }

    public void setTaskUuid(String taskUuid) {
        this.taskUuid = taskUuid;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getSubTaskUuid() {
        return subTaskUuid;
    }

    public void setSubTaskUuid(String subTaskUuid) {
        this.subTaskUuid = subTaskUuid;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOpaque() {
        return opaque;
    }

    public void setOpaque(String opaque) {
        this.opaque = opaque;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
