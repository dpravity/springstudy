package com.example.springstudy.controller.board;

import com.example.springstudy.entity.board.BoardEntity;
import com.example.springstudy.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시물 목록
     * @param modelAndView
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView boardList(ModelAndView modelAndView){
        modelAndView.setViewName("board/boardList");
        modelAndView.addObject("boardList", boardService.boardList());
        return modelAndView;
    }

    /**
     * 게시물 상세 보기
     * @param modelAndView
     * @param boardSeq
     * @return
     */
    @RequestMapping(value = "/detail/{boardSeq}", method = RequestMethod.GET)
    public ModelAndView boardDetail(ModelAndView modelAndView, @PathVariable("boardSeq") Integer boardSeq){
        modelAndView.setViewName("board/boardDetail");
        modelAndView.addObject("boardDetail", boardService.boardDetail(boardSeq));
        return modelAndView;
    }


    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String boardInsert(){
        return "board/boardInsert";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String boardSave(BoardEntity boardEntity){
        // TODO validation
//        boardEntity.setCreateBy(boardEntity.getBoardWriter());
//        boardEntity.setModifyBy(boardEntity.getBoardWriter());
        BoardEntity board = boardService.boardInsert(boardEntity);
        // TODO 저장 체크
        return "redirect:/board/list";
    }




}
