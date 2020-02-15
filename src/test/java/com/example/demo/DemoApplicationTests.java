package com.example.demo;

import org.jodconverter.JodConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class DemoApplicationTests {


    @Test
    void contextLoads() {
        try {
            //据说jodconverter可以自动寻找转码路径，windows上试了可以，linux上好像没法自动找到路径，会报officehome not set and could not be auto-detected，所以设置转码工具路径
            LocalOfficeManager manager = LocalOfficeManager.builder().officeHome("C:/Program Files/LibreOffice").install().build();
            manager.start();
            JodConverter.convert(new File("E:\\员工季度考核打分表 - 胡丽青-三季度.xlsx")).to(new File("E:\\员工季度考核打分表 - 胡丽青-三季度.pdf")).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

}
