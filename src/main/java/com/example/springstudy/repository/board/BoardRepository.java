package com.example.springstudy.repository.board;

import com.example.springstudy.entity.board.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Override
    List<BoardEntity> findAll();

    @Override
    BoardEntity getReferenceById(Integer integer);

    @Override
    <S extends BoardEntity> S saveAndFlush(S entity);

}
