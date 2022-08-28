package com.example.springstudy.service.board;

import com.example.springstudy.entity.board.BoardEntity;
import com.example.springstudy.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 의존성 주입 방식 중 생성자 주입 방식
    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시물 전체 목록
     * @return
     */
    public List<BoardEntity> boardList(){
        return this.boardRepository.findAll();
    }

    /**
     * 게시물 상세 보기
     * @param boardSeq
     * @return
     */
    public BoardEntity boardDetail(Integer boardSeq){
        return this.boardRepository.getReferenceById(boardSeq);
    }

    /**
     * 게시물 저장
     * @param boardEntity
     * @return
     */
    public BoardEntity boardInsert(BoardEntity boardEntity){
        return this.boardRepository.saveAndFlush(boardEntity);
    }

}
