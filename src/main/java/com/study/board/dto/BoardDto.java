package com.study.board.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
