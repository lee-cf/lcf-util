package com.example.lcfutil.chandao;

import com.example.lcfutil.chandao.pojo.NewTask;
import com.example.lcfutil.chandao.pojo.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lichaofeng
 * @date :2025/1/8 17:31
 * @description :
 * @modyified By:
 */

@Service
public class ConvertService {

    public List<NewTask> handleTask(List<Task> taskList) {
        return taskList.stream()
                .map(task -> {
                    NewTask newTask = new NewTask();
                    BeanUtils.copyProperties(task, newTask);
                    return newTask;
                })
                .collect(Collectors.toList());
    }

}