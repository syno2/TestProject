package com.ex.test.TestProject;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Controller
@AllArgsConstructor
@RequestMapping("/Board")
public class TestController {

    private BoardRepository boardRepository;

    public void clean(){
        boardRepository.deleteAll();
    }

    @GetMapping("/index")
    public String index(@PageableDefault Pageable pageable,Model model){
        List<Board> list = boardRepository.findAll();

        model.addAttribute("boardList",list);

        return "index";
    }

    @GetMapping("/about")
    public String about(@PageableDefault Pageable pageable,Model model){
        return "about";
    }

    @GetMapping("/post")
    public String post(@PageableDefault Pageable pageable,Model model){
        return "post";
    }

    @GetMapping("/contact")
    public String contact(@PageableDefault Pageable pageable,Model model){
        return "contact";
    }

    @PostMapping("/insert")
    public String create(Board board){

        Random rand = new Random();
        Integer random = rand.nextInt(100)+1;

        System.out.println(random);

        System.out.println(board.getArticle());
        System.out.println(board.getBoardName());

        boardRepository.save(Board.builder()
                .boardName(board.getBoardName())
                .article(board.getArticle())
                .randomNum(random)
                .writeDate(LocalDateTime.now())
                .build());

        return "redirect:/Board/index";
    }

    @RequestMapping(value = "/test")
    public String testControl(@PageableDefault Pageable pageable, Model model) {
        for (int i = 0; i < 10; i++)
        boardRepository.save(Board.builder()
        .boardName("Test중입니다.")
                .article("내용 입니다.")
                .writeDate(LocalDateTime.now()).build());

        List<Board> list = boardRepository.findAll();

        model.addAttribute("boardList",list);

        clean();

        return "/Test";
    }

}
