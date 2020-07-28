package com.kh.spring10home.entity;

public class BoardDto {
    
	private int board_no;
	private String board_head;
	private String board_title;
	private String board_writer;
	private String board_content;
	private String board_date;
	private int board_read;
	private int board_replycount;
	private int group_no;
	private int depth;
	private int super_no;
	
	

	
	public BoardDto() {
		super();
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_head() {
		return board_head;
	}
	public void setBoard_head(String board_head) {
		this.board_head = board_head;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public int getBoard_read() {
		return board_read;
	}
	public void setBoard_read(int board_read) {
		this.board_read = board_read;
	}
	public int getBoard_replycount() {
		return board_replycount;
	}
	public void setBoard_replycount(int board_replycount) {
		this.board_replycount = board_replycount;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getSuper_no() {
		return super_no;
	}
	public void setSuper_no(int super_no) {
		this.super_no = super_no;
	}
	
	
	
	
}
