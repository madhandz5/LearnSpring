package com.spring.springmvc.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springmvc.board.model.vo.Notice;

import common.util.Paging;

@Repository
public class NoticeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public int contentCnt() {
		return sqlSession.selectOne("Notice.contentCnt");
	}

	public List<Notice> selectNoticeList(Paging page, String orderby) {

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", page);
		data.put("orderby", orderby);

		return sqlSession.selectList("Notice.selectNoticeList", data);
	}

	public int insertNotice(Notice n) {
		return sqlSession.insert("Notice.insertNotice", n);
	}

	public int insertFile(Map<String, Object> file) {

		return sqlSession.insert("Notice.insertFile", file);
	}

	public Notice noticeDetail(int noticeNo) {
		return sqlSession.selectOne("Notice.noticeDetail", noticeNo);
	}

	public List<Map<String, String>> selectFiles(int noticeNo) {
		return sqlSession.selectList("Notice.selectFiles", noticeNo);
	}

	public int deleteNotice(int noticeNo) {
		return sqlSession.delete("Notice.deleteNotice", noticeNo);
	}

	public int deleteFiles(int noticeNo) {
		return sqlSession.delete("Notice.deleteFiles", noticeNo);
	}
}
