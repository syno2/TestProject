package com.ex.test.TestProject;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Board {

    @Id
    @Column(name = "board_no")
    @GeneratedValue
    private long boardNo;

    @Column(length = 500, nullable = false, name = "board_name")
    private String boardName;

    @Column(length = 500, nullable = false, name = "article")
    private String article;

    @Column(nullable = false, name = "random_num")
    private Integer randomNum;

    @Column
    private LocalDateTime writeDate;

    @Builder
    public Board(String boardName,String article,Integer randomNum,LocalDateTime writeDate){
        this.boardName = boardName;
        this.article = article;
        this.randomNum = randomNum;
        this.writeDate = writeDate;
    }
}
