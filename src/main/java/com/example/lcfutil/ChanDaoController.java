package com.example.lcfutil;

import com.example.lcfutil.chandao.ConvertService;
import com.example.lcfutil.chandao.ExcelService;
import com.example.lcfutil.chandao.pojo.NewTask;
import com.example.lcfutil.chandao.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author : lichaofeng
 * @date :2025/1/8 17:27
 * @description :
 * @modyified By:
 */
@RestController
@RequestMapping("/chandao")
public class ChanDaoController {

    @Autowired
    private ExcelService excelService;
    @Autowired
    private ConvertService convertService;

    // 示例：导出任务列表为 Excel 文件
    @PostMapping("/convertTasks")
    public ResponseEntity<byte[]> convertTasks(@RequestParam("file") MultipartFile file) throws IOException {
        List<Task> taskList = excelService.readExcel(file);
        List<NewTask> newTaskList = convertService.handleTask(taskList);
        // 调用服务将任务列表导出为 Excel
        byte[] excelFile = excelService.writeExcel(taskList, Task.class);
        // 设置响应头，指定文件名
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=tasks.xlsx");
        // 返回 Excel 文件字节数组
        return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
    }
}