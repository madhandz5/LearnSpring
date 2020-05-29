package com.spring.springmvc.board.model.service;

import java.util.List;
import java.util.Map;

import com.spring.springmvc.board.model.vo.Notice;

public interface NoticeService {

	public Map<String, Object> selectNoticeList(String orderby, int currentPage, int cntPerPage);
	public Map<String, Object> noticeDetail(int noticeNo);
	public int insertNotice(Notice n, List<Map<String, Object>> fileData);
	public int insertFile(List<Map<String,Object>> fileData);
	public int deleteNotice(int noticeNo);
	public void deleteFiles(int noticeNo);

}
