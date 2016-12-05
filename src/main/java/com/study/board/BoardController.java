package com.study.board;

import com.study.board.dto.BoardDto;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostConstruct
    public void testInit(){
        for(int i=0 ; i < 100 ;i++){
            BoardDto dto = new BoardDto();
            dto.testData("subject"+i, "content"+i, "writer"+i, i+"", "tag"+i);
            boardService.doWrite(dto);
        }
    }

    @GetMapping("/")
    public String rootPage(){
        return "redirect:/list.do";
    }

    @GetMapping("/list.do")
    public String list(Model model, @PageableDefault(sort = { "idx" }, direction = Sort.Direction.DESC, size = 15) Pageable pageable){
        model.addAttribute("title", "BordList");
        model.addAttribute("list", boardService.getBoardList(pageable));
        return "list";
    }

    @GetMapping("/writeInit.do")
    public String writeInit(Model model){
        model.addAttribute("title", "WriteBoard");
        return "write";
    }

    @PostMapping(value = "/doWrite.do")
    public String doWrite(@ModelAttribute BoardDto dto){
        boardService.doWrite(dto);
        return "redirect:/list.do";
    }

    @GetMapping(value = "/view.do")
    public String view(HttpServletRequest request, Model model){
        model.addAttribute("title", "modify");
        int idx = Integer.parseInt(request.getParameter("idx"));
        BoardDto view = boardService.getView(idx);
        model.addAttribute("view", view);

        return "view";
    }

    @GetMapping(value = "/modify.do")
    public String modify(HttpServletRequest request, Model model){
        model.addAttribute("title", "modify");
        int idx = Integer.parseInt(request.getParameter("idx"));
        BoardDto view =  boardService.getView(idx);
        model.addAttribute("view", view);
        return "modify";
    }

    @PostMapping(value = "/doModify.do")
    public String doModify(@ModelAttribute BoardDto dto, Model model){
        model.addAttribute("view", dto);
        boolean result = boardService.modifyView(dto);
        if(result){
            model.addAttribute("title", "view");
            return "view";
        }else{
            model.addAttribute("title", "modify");
            return "modify";
        }
    }

    @PostMapping(value = "/doDelete.do")
    public String doDelete(@ModelAttribute BoardDto dto, Model model){
        boolean result = boardService.deleteView(dto);

        if(result){
            return "redirect:/list.do";
        }else{
            model.addAttribute("title", "modify");
            model.addAttribute("view", dto);
            return "modify";
        }
    }

}
