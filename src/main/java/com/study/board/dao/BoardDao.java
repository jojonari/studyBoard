package com.study.board.dao;

import com.study.board.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDao extends JpaRepository<BoardDto, Integer> {

}
