package com.study.board;

import com.study.board.dto.BoardDto;
import com.study.board.dto.ResultDto;
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

import javax.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String rootPage(Model model){
        return "redirect:/list.do";
    }

    @GetMapping("/list.do")
    public String list(Model model, @PageableDefault(sort = { "idx" }, direction = Sort.Direction.DESC, size = 2) Pageable pageable){
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
        model.addAttribute("result", new ResultDto());

        return "view";
    }


    @GetMapping(value = "/modify.do")
    public String modify(HttpServletRequest request, Model model){
        model.addAttribute("title", "modify");
        int idx = Integer.parseInt(request.getParameter("idx"));
        BoardDto view =  boardService.getView(idx);
        model.addAttribute("view", view);
        model.addAttribute("result", new ResultDto());
        return "modify";
    }

    @PostMapping(value = "/doModify.do")
    public String doModify(@ModelAttribute BoardDto dto, Model model){
        model.addAttribute("title", "modify");
        ResultDto result = boardService.modifyView(dto);
        model.addAttribute("view", dto);
        model.addAttribute("result", result);
        return result.getTargetUrl();
    }

    @PostMapping(value = "/doDelete.do")
    public String doDelete(@ModelAttribute BoardDto dto, Model model){
        ResultDto result = boardService.deleteView(dto);

        if(result.getResultCode() == 0){
            model.addAttribute("view", dto);
        }
        model.addAttribute("title", "BordList");
        return "redirect:/list.do";
    }

}
