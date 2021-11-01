/*@Time : 2021/7/9 1:30
 *@Author : 韦佗
 *@File : QueryWebInfo.java
 *@Software : IntelliJ IDEA
 */
package com.bs.wt.backstage.bean.phoenix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryWebInfo {

    // 查询信息 title
    private String title = "";
    // 当前页
    private int pageNum = 0;
    // 每页最大数
    private int pageSize = 10;
}
