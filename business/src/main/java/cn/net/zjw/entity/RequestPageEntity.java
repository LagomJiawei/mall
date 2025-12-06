package cn.net.zjw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author ZhangJw
 * @date 2025年12月06日 16:23
 * 分页请求实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestPageEntity implements Serializable {

    private static final int DEFAULT_PAGE_NO = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 页码，默认从一页开始
     */
    private Integer pageNo = DEFAULT_PAGE_NO;

    /**
     * 每页大小，默认一页查询10条数据
     */
    private Integer pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 获取分页开始位置
     *
     * @return 分页开始位置
     */
    public Integer getPageBegin() {
        if (Objects.isNull(this.pageNo)) {
            this.pageNo = DEFAULT_PAGE_NO;
        }

        if (Objects.isNull(this.pageSize)) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }

        return (this.pageNo - 1) * this.pageSize;
    }
}