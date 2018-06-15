package com.baixiang.chuxing.user.model.bo;

/**
 * Created by liming on 2017/4/5.
 */

public class PageBo {
    //             "numberOfElements": 2,
//             "sort": [
//    {
//        "direction": "DESC",
//            "property": "createDatetime",
//            "ignoreCase": false,
//            "nullHandling": "NATIVE",
//            "descending": true,
//            "ascending": false
//    }
//    ]


    private boolean first;//是否第一页
    private boolean last;//是否最后一页
    private int totalPages;//所有页面
    private long totalElements;//所有条目
    private int size;//每页条目
    private long number;//当前页0开始
    private Object content;

    public PageBo() {
    }

    public PageBo(int number, int size) {
        this.number = number;
        this.size = size;
    }

    public boolean isFirst() {
        if (number == 0) {
            first = true;
        }
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        if (getTotalPages() == number + 1) {
            last = true;
        }
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        int v = 0;
        if (totalElements % size > 0) {
            v = 1;
        }
        return (int) (totalElements / size) + v;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
