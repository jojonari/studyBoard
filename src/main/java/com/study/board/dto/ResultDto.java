package com.study.board.dto;

import lombok.Getter;

@Getter
public class ResultDto {

    private int resultCode;
    private String resultMsg="";
    private String targetUrl;

    public ResultDto() {}

    public ResultDto(int resultCode, String resultMsg, String targetUrl){
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.targetUrl = targetUrl;
    }
}

