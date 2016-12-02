package com.study.board.service;

import com.study.board.dao.BoardDao;
import com.study.board.dto.BoardDto;
import com.study.board.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl  implements BoardService{

    @Autowired
    BoardDao boardDao;

    @Override
    public Page<BoardDto> getBoardList(Pageable pageable) {
        Page<BoardDto> boardDaoAll = boardDao.findAll(pageable);

        return boardDaoAll;
    }

    @Override
    public void doWrite(BoardDto dto) {
        boardDao.save(dto);
    }

    @Override
    public BoardDto getView(int idx) {
        return boardDao.findOne(idx);
    }

    @Override
    public ResultDto deleteView(BoardDto dto) {
        ResultDto resultDto;
        BoardDto oldData = boardDao.getOne(dto.getIdx());

        if(oldData.getPasswd().equals(dto.getPasswd())){
            boardDao.delete(dto.getIdx());
            resultDto = new ResultDto(1,"삭제성공","redirect:/list.do");
        }else{
            resultDto = new ResultDto(0,"삭제실패-PW를 확인해라!!","modify");
        }
        return resultDto;
    }

    @Override
    public ResultDto modifyView(BoardDto dto) {
        ResultDto resultDto;
        BoardDto oldData = boardDao.getOne(dto.getIdx());

        if(oldData.getPasswd().equals(dto.getPasswd())){
            boardDao.save(dto);
            resultDto = new ResultDto(1,"수정성공","view");
        }else{
            resultDto = new ResultDto(0,"수정실패-PW를 확인해라!!","modify");
        }
        return resultDto;

    }
}
