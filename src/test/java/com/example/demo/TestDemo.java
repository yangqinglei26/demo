package com.example.demo;

import com.jayway.jsonpath.JsonPath;
import org.jodconverter.JodConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yql
 * @Date 2019/11/20 16:34
 * @Version 1.0
 */
public class TestDemo {

    /**
     * dff
     * store : {"book":[{"category":"reference","author":"Nigel Rees","title":"Sayings of the Century","price":8.95,"isbn":"0-553-21311-3"},{"category":"fiction","author":"Evelyn Waugh","title":"Sword of Honour","price":12.99},{"category":"fiction","author":"Herman Melville","title":"Moby Dick","isbn":"0-553-21311-3","price":8.99},{"category":"fiction","author":"J. R. R. Tolkien","title":"The Lord of the Rings","isbn":"0-395-19395-8","price":22.99}],"bicycle":{"color":"red","price":19.95}}
     * expensive : 10
     */

    private StoreBean store;
    private int expensive;

    @Test
    public void toPdf() {
        try {
            //据说jodconverter可以自动寻找转码路径，windows上试了可以，linux上好像没法自动找到路径，会报officehome not set and could not be auto-detected，所以设置转码工具路径
            LocalOfficeManager manager = LocalOfficeManager.builder().officeHome("C:/Program Files/LibreOffice").install().build();
            manager.start();
            JodConverter.convert(new File("E:\\员工季度考核打分表 - 胡丽青-三季度.xlsx")).to(new File("E:\\员工季度考核打分表 - 胡丽青-三季度.pdf")).execute();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void readJson() {
        String json = "{\n" +
                "    \"store\": {\n" +
                "        \"book\": [\n" +
                "            {\n" +
                "                \"category\": \"reference\",\n" +
                "                \"author\": \"Nigel Rees\",\n" +
                "                \"title\": \"Sayings of the Century\",\n" +
                "                \"price\": 8.95\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Evelyn Waugh\",\n" +
                "                \"title\": \"Sword of Honour\",\n" +
                "                \"price\": 12.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"Herman Melville\",\n" +
                "                \"title\": \"Moby Dick\",\n" +
                "                \"isbn\": \"0-553-21311-3\",\n" +
                "                \"price\": 8.99\n" +
                "            },\n" +
                "            {\n" +
                "                \"category\": \"fiction\",\n" +
                "                \"author\": \"J. R. R. Tolkien\",\n" +
                "                \"title\": \"The Lord of the Rings\",\n" +
                "                \"isbn\": \"0-395-19395-8\",\n" +
                "                \"price\": 22.99\n" +
                "            }\n" +
                "        ],\n" +
                "        \"bicycle\": {\n" +
                "            \"color\": \"red\",\n" +
                "            \"price\": 19.95\n" +
                "        }\n" +
                "    },\n" +
                "    \"expensive\": 10\n" +
                "}";
        Integer expensive = JsonPath.read(json,"$.expensive");
        System.out.printf("expensive转换后的值为%s",expensive);
        System.out.printf("时间 %tF %tT",new Date(),new Date());
    }

    public StoreBean getStore() {
        return store;
    }

    public void setStore(StoreBean store) {
        this.store = store;
    }

    public int getExpensive() {
        return expensive;
    }

    public void setExpensive(int expensive) {
        this.expensive = expensive;
    }

    public static class StoreBean {
        /**
         * book : [{"category":"reference","author":"Nigel Rees","title":"Sayings of the Century","price":8.95},{"category":"fiction","author":"Evelyn Waugh","title":"Sword of Honour","price":12.99},{"category":"fiction","author":"Herman Melville","title":"Moby Dick","isbn":"0-553-21311-3","price":8.99},{"category":"fiction","author":"J. R. R. Tolkien","title":"The Lord of the Rings","isbn":"0-395-19395-8","price":22.99}]
         * bicycle : {"color":"red","price":19.95}
         */

        private BicycleBean bicycle;
        private List<BookBean> book;

        public BicycleBean getBicycle() {
            return bicycle;
        }

        public void setBicycle(BicycleBean bicycle) {
            this.bicycle = bicycle;
        }

        public List<BookBean> getBook() {
            return book;
        }

        public void setBook(List<BookBean> book) {
            this.book = book;
        }

        public static class BicycleBean {
            /**
             * color : red
             * price : 19.95
             */

            private String color;
            private double price;

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }
        }

        public static class BookBean {
            /**
             * category : reference
             * author : Nigel Rees
             * title : Sayings of the Century
             * price : 8.95
             * isbn : 0-553-21311-3
             */

            private String category;
            private String author;
            private String title;
            private double price;
            private String isbn;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getIsbn() {
                return isbn;
            }

            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }
        }
    }
}
