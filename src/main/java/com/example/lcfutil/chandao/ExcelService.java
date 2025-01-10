package com.example.lcfutil.chandao;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.example.lcfutil.chandao.pojo.Task;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : lichaofeng
 * @date :2025/1/8 17:06
 * @description :
 * @modyified By:
 */

@Service
public class ExcelService {
    // 读取 Excel 文件
    public <T> List<T> readExcel(MultipartFile file) throws IOException {
        List<T> dataList = new ArrayList<>();

        // 获取文件输入流
        InputStream inputStream = file.getInputStream();

        // 使用 EasyExcel 读取 Excel 文件
        EasyExcel.read(inputStream, Task.class, new PageReadListener<T>(sheetData -> {
                    // 每次读取到一页的数据时将其加入 taskList
                    dataList.addAll(sheetData);
                }))
                .sheet()  // 默认读取第一个 sheet
                .doRead(); // 执行读取
        return dataList;
    }

    public <T> byte[] writeExcel(List<T> dataList, Class<T> clazz) throws IOException {
        // 创建输出流
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // 使用 EasyExcel 写数据到字节流
            EasyExcel.write(outputStream, clazz)
                    .sheet("任务数据")  // sheet 名称
                    .doWrite(dataList);  // 写入数据

            return outputStream.toByteArray();  // 返回 Excel 文件的字节数组
        }
    }

}