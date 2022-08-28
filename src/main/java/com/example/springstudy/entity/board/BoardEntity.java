package com.example.springstudy.entity.board;

import com.example.springstudy.entity.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BoardEntity extends BaseEntity {

    // 게시물 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_seq")
    private Integer boardSeq;

    // 게시물 제목
    @Column(name = "board_title")
    private String boardTitle;

    // 게시물 내용
    @Column(name = "board_contents")
    private String boardContents;

    // 작성자
    @Column(name = "board_writer")
    private String boardWriter;

}
