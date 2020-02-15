package com.example.config;


import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description TODO
 * @Author yql
 * @Date 2019/11/6 20:14
 * @Version 1.0
 */
public class DateEditor extends PropertyEditorSupport {

    /**
     * store : {"book":[{"category":"reference","author":"Nigel Rees","title":"Sayings of the Century","price":8.95,"isbn":"0-553-21311-3"},{"category":"fiction","author":"Evelyn Waugh","title":"Sword of Honour","price":12.99},{"category":"fiction","author":"Herman Melville","title":"Moby Dick","isbn":"0-553-21311-3","price":8.99},{"category":"fiction","author":"J. R. R. Tolkien","title":"The Lord of the Rings","isbn":"0-395-19395-8","price":22.99}],"bicycle":{"color":"red","price":19.95}}
     * expensive : 10
     */

    private StoreBean store;
    private int expensive;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(!StringUtils.isEmpty(text)){
            try {
                super.setValue(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(text)));
                return;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            super.setAsText(null);
        }

    }



    @Override
    public String getAsText() {
        return "aaa";
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
