package com.example.lcfutil.chandao.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class NewTask {

    @ExcelProperty("编号")
    private String taskId;

    @ExcelProperty("所属项目")
    private String project;

    @ExcelProperty("所属执行")
    private String execution;

    @ExcelProperty("所属模块")
    private String module;

    @ExcelProperty("相关研发需求")
    private String relatedRequirement;

    @ExcelProperty("来源Bug")
    private String sourceBug;

    @ExcelProperty("任务名称")
    private String taskName;

    @ExcelProperty("任务描述")
    private String taskDescription;

    @ExcelProperty("父任务")
    private String parentTask;

    @ExcelProperty("任务类型")
    private String taskType;

    @ExcelProperty("优先级")
    private String priority;

    @ExcelProperty("预计开始")
    private Date estimatedStart;

    @ExcelProperty("实际开始")
    private Date actualStart;

    @ExcelProperty("截止日期")
    private Date deadline;

    @ExcelProperty("任务状态")
    private String taskStatus;

    @ExcelProperty("最初预计")
    private String initialEstimate;

    @ExcelProperty("总计消耗")
    private String totalConsumption;

    @ExcelProperty("预计剩余")
    private String estimatedRemaining;

    @ExcelProperty("抄送给")
    private String ccTo;

    @ExcelProperty("进度")
    private String progress;

    @ExcelProperty("任务模式")
    private String taskMode;

    @ExcelProperty("由谁创建")
    private String createdBy;

    @ExcelProperty("创建日期")
    private Date createdDate;

    @ExcelProperty("指派给")
    private String assignedTo;

    @ExcelProperty("指派日期")
    private Date assignedDate;

    @ExcelProperty("由谁完成")
    private String completedBy;

    @ExcelProperty("实际完成")
    private Date actualCompletion;

    @ExcelProperty("由谁取消")
    private String cancelledBy;

    @ExcelProperty("取消时间")
    private Date cancellationTime;

    @ExcelProperty("由谁关闭")
    private String closedBy;

    @ExcelProperty("关闭时间")
    private Date closureTime;

    @ExcelProperty("关闭原因")
    private String closureReason;

    @ExcelProperty("最后修改")
    private String lastModifiedBy;

    @ExcelProperty("最后修改日期")
    private Date lastModifiedDate;

    @ExcelIgnore
    private String attachments; // 附件字段暂不映射

}
