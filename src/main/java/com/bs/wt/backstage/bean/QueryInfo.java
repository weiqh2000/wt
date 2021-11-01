/*@Time : 2021/7/1 1:16
 *@Author : 韦佗
 *@File : QueryInfo.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryInfo {

    // 查询信息 username
    private String query = "";
    // 当前页
    private int pageNum = 1;
    // 每页最大数
    private int pageSize = 1;

}
