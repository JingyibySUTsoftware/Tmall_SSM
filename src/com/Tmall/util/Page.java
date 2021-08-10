package com.Tmall.util;

/**
 * @author jingyi
 * @Classname Page
 * @description 用于分页的工具类
 * @date 2021/8/3 9:40
 */
public class Page {
    int start;//开始页数
    int count;//每页个数
    int total;//总个数
    String param;

    public static final int defaultCount=5;
    public Page() {
        count=defaultCount;
    }
    public Page(int start) {
        count=defaultCount;
    }
    public Page(int start,int count) {
        this.start=start;
        this.count=count;
    }

    public boolean isHasPreviouse() {
        if(start==0) {
            return false;
        }
        return true;
    }

    public boolean isHasNext() {
        if(start==getLast()) {
            return false;
        }
        return true;
    }
    //获取总页数
    public int getTotalPage() {
        int totalPage=(0==total%count)?(total/count):((total/count)+1);
        totalPage=(0==totalPage)?1:totalPage;
        return totalPage;
    }
    //获取最后一页的开始页
    public int getLast(){
        int last=(0==total%count)?(total-count):(total-(total%count));
        last=last<0?0:last;
        return last;
    }
    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", param=" + param
                + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()=" + isHasNext() + ", getTotalPage()="
                + getTotalPage() + ", getLast()=" + getLast() + "]";
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }
}
