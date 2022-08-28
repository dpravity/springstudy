package com.example.springstudy.entity.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    // 등록일자
    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    // 등록자
    @CreatedBy
    @Column(name = "create_by", updatable = false)
    private String createBy = "";

    // 수정일자
    @LastModifiedDate
    @Column(name = "modify_date")
    private LocalDateTime modifyDate = LocalDateTime.now();

    // 수정자
    @LastModifiedBy
    @Column(name = "modify_by")
    private String modifyBy = "";

}
