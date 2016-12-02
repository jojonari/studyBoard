package com.study.board.service;

import com.study.board.dto.BoardDto;
import com.study.board.dto.ResultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {

    Page<BoardDto> getBoardList(Pageable pageable);

    void doWrite(BoardDto dto);

    BoardDto getView(int idx);

    ResultDto deleteView(BoardDto dto);

    ResultDto modifyView(BoardDto dto);


}
