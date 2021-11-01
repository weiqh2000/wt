/*@Time : 2021/6/22 19:16
 *@Author : 韦佗
 *@File : JsonCode.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;

public enum JsonCode {

    SUCCESS(0),
    ERROR(-1),
    LOGIN(-9);

    private Integer value;

    //枚举类型的构造函数默认为private，因为枚举类型的初始化要在当前枚举类中完成。
    JsonCode(Integer value){
        this.value= value;
    }

    public Integer getValue() {
        return value;
    }
}
