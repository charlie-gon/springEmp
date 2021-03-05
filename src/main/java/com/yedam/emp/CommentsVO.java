package com.yedam.emp;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentsVO {
	private String id;
	private String name;
	private String content;
	private String board_id;
	private String out_msg;
	private String[] ids; // @JsonIgnore
	@JsonFormat(pattern = "yyyyMMddHHmmss") // 교재 p.421
	private Date wdate;
}
