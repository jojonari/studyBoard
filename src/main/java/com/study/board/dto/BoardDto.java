package com.study.board.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class BoardDto {
    @Id
    @GeneratedValue
    private int idx;
    private String subject;
    private String content;
    private String writer;
    private String passwd;


   //생각좀 해보자.
    private String tag;
    // 태그 기능은 스트링이나 리스트로 받으면 안될듯
    // 태깅수에 따라 상위노출, 검색이 지원 되어야함.
    // 그럴려면 레파지토리를 나눠얄듯?
    /*
    * private int idx;
    * private String tag;
    * private int taggingCnt;
    *
    * http://jdm.kr/blog/141 - > 코멘트 관련jpa조인
    * */

    public void testData(String subject, String content, String writer, String  passwd, String tag){
        this.subject = subject;
        this.content = content;
        this.writer = writer;
        this.passwd = passwd;
        this.tag = tag;

    }

}
