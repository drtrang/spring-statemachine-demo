package com.github.trang.statemachine.model.domain;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Accessors(fluent = true)
@Getter
@Setter
@Table(name = "state_machine")
public class House implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("status", status)
                .add("remark", remark)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .toString();
    }
}