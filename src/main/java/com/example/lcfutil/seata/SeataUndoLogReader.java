package com.example.lcfutil.seata;

import io.seata.rm.datasource.undo.BranchUndoLog;
import io.seata.rm.datasource.undo.parser.KryoUndoLogParser;

import java.sql.*;

public class SeataUndoLogReader {

    public static void main(String[] args) {
        // JDBC 连接信息
        String url = "jdbc:mysql://192.168.4.82:3306/dy_user"; // 替换为你的数据库 URL
        String username = "root"; // 替换为你的数据库用户名
        String password = "zszc"; // 替换为你的数据库密码

        long branchId = 5945343796702470385L; // 替换为实际的 branchId

        // SQL 查询语句
        String sql = "SELECT rollback_info FROM undo_log WHERE branch_id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, branchId);

            // 执行查询
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // 获取 rollback_info 字段的二进制数据
                    byte[] rollbackInfo = resultSet.getBytes("rollback_info");

                    // 打印二进制数据（可以通过 16 进制查看）
                    System.out.println("Rollback Info (Hex): " + toHex(rollbackInfo));

                    // 反序列化该数据（后续步骤）
                    BranchUndoLog myObjectList = deserializeKryo(rollbackInfo);

                    // 输出反序列化后的对象
                    System.out.println("Deserialized Object List: " + myObjectList);
                } else {
                    System.out.println("No matching data found for branch_id: " + branchId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 将 byte[] 转换为 16 进制字符串
    private static String toHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    // 使用 Kryo 反序列化二进制数据
    private static BranchUndoLog deserializeKryo(byte[] kryoData) {
        KryoUndoLogParser parser = new KryoUndoLogParser();
        parser.init();
        return parser.decode(kryoData);
    }
}
