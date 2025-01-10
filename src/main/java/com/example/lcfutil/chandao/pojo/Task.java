package com.example.lcfutil.chandao.pojo;

/**
 * @author : lichaofeng
 * @date :2025/1/8 17:10
 * @description :
 * @modyified By:
 */

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Task {

    @ExcelProperty("编号")
    private String taskId;               // 编号

    @ExcelProperty("所属项目")
    private String projectName;          // 所属项目

    @ExcelProperty("所属执行")
    private String executor;             // 所属执行

    @ExcelProperty("所属模块")
    private String module;               // 所属模块

    @ExcelProperty("相关研发需求")
    private String relatedAndRequirement; // 相关研发需求

    @ExcelProperty("来源Bug")
    private String bugSource;            // 来源Bug

    @ExcelProperty("任务名称")
    private String taskName;             // 任务名称

    @ExcelProperty("任务描述")
    private String taskDescription;      // 任务描述

    @ExcelProperty("父任务")
    private String parentTask;           // 父任务

    @ExcelProperty("任务类型")
    private String taskType;             // 任务类型

    @ExcelProperty("优先级")
    private String priority;             // 优先级

    @ExcelProperty("预计开始")
    private LocalDate expectedStartDate; // 预计开始

    @ExcelProperty("实际开始")
    private LocalDateTime actualStartDate; // 实际开始

    @ExcelProperty("截止日期")
    private LocalDate deadline;          // 截止日期

    @ExcelProperty("任务状态")
    private String taskStatus;           // 任务状态

    @ExcelProperty("最初预计")
    private LocalDateTime initialEstimateDate; // 最初预计

    @ExcelProperty("总计消耗")
    private Double totalConsumed;        // 总计消耗

    @ExcelProperty("预计剩余")
    private Double remainingEstimate;    // 预计剩余

    @ExcelProperty("抄送给")
    private List<String> ccList;         // 抄送给

    @ExcelProperty("进度")
    private String progress;             // 进度

    @ExcelProperty("任务模式")
    private String taskMode;             // 任务模式

    @ExcelProperty("由谁创建")
    private String createdBy;            // 由谁创建

    @ExcelProperty("创建日期")
    private LocalDateTime creationDate;  // 创建日期

    @ExcelProperty("指派给")
    private String assignedTo;           // 指派给

    @ExcelProperty("指派日期")
    private LocalDateTime assignedDate;  // 指派日期

    @ExcelProperty("由谁完成")
    private String completedBy;          // 由谁完成

    @ExcelProperty("实际完成")
    private LocalDateTime completionDate; // 实际完成

    @ExcelProperty("由谁取消")
    private String cancelledBy;          // 由谁取消

    @ExcelProperty("取消时间")
    private LocalDateTime cancellationDate; // 取消时间

    @ExcelProperty("由谁关闭")
    private String closedBy;             // 由谁关闭

    @ExcelProperty("关闭时间")
    private LocalDateTime closureDate;   // 关闭时间

    @ExcelProperty("关闭原因")
    private String closureReason;        // 关闭原因

    @ExcelProperty("最后修改")
    private String lastModifiedBy;       // 最后修改

    @ExcelProperty("最后修改日期")
    private LocalDateTime lastModifiedDate; // 最后修改日期

    @ExcelIgnore
    private String attachments; // 附件字段暂不映射

}
