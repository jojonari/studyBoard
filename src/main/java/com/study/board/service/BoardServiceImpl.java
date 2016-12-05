package com.study.board.service;

import com.study.board.dao.BoardDao;
import com.study.board.dto.BoardDto;
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
    public boolean deleteView(BoardDto dto) {
        boolean result;
        if(passwdCheck(dto)) {
            boardDao.delete(dto.getIdx());
            result =true;
        }else{
            result = false;
        }
        System.out.println("deleteView : " + result);

        return result;
    }
//todo : 타켓유알엘 컨트롤러에서 분기처리
    //삭제실패 이셉션에서 처리
    @Override
    public boolean modifyView(BoardDto dto) {
        boolean result;
        if(passwdCheck(dto)) {
            boardDao.save(dto);
            result =true;
        }else{
            result = false;
        }
        System.out.println("modifyView : " + result);
        return result;
    }

    private boolean passwdCheck(BoardDto dto){
        BoardDto oldData = boardDao.getOne(dto.getIdx());
        boolean result;

        if(oldData.getPasswd().equals(dto.getPasswd())){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
}
