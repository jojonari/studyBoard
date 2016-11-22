package com.study.board;

import com.study.board.dao.BoardDao;
import com.study.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardDao boardDao;

    @RequestMapping("/list.do")
    public String list(Model model){
        List<BoardDto> list = boardDao.findAll();
        model.addAttribute("list", list);

        model.addAttribute("title", "BordList");
        return "list";
    }

    @RequestMapping("/writeInit.do")
    public String writeInit(Model model){
        model.addAttribute("title", "WriteBoard");
        return "write";
    }

    @RequestMapping(value = "/doWrite.do", method= RequestMethod.POST)
    public String doWrite(@ModelAttribute BoardDto dto, Model model){

        boardDao.save(dto);

        List<BoardDto> list = boardDao.findAll();
        model.addAttribute("list", list);

        model.addAttribute("title", "BordList");
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/view.do", method= RequestMethod.GET)
    public String view(HttpServletRequest request, Model model){
        String idx = request.getParameter("idx");

        BoardDto view = boardDao.findOne(Integer.parseInt(idx));
        model.addAttribute("view", view);

        model.addAttribute("title", "Modify");
        return "view";
    }

    @RequestMapping(value = "/updateView.do", method= RequestMethod.POST)
    public String updateView(@ModelAttribute BoardDto dto, Model model){
        boardDao.delete(dto.getIdx());
        boardDao.save(dto);
        model.addAttribute("title", "BordList");
        return "redirect:/list.do";
    }

    @RequestMapping(value = "/delete.do", method= RequestMethod.GET)
    public String delete(HttpServletRequest request, Model model){
        int idx = Integer.parseInt(request.getParameter("idx"));
        boardDao.delete(idx);
        model.addAttribute("title", "BordList");
        return "redirect:/list.do";
    }

}
