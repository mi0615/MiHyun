package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.AdminController;
import com.example.domain.Qnacomment;
import com.example.persistence.QnacommentRepository;

@Service
public class QnacommentServiceImpl implements QnacommentService {

	static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private QnacommentRepository QnacomRepo;
	
	//답글등록
	@Override
	public void insertReply(Qnacomment qc) {
		logger.info("답글저장");
		QnacomRepo.save(qc);
	}
	
	//사용자 답글보기
	@Override
	public List<Qnacomment> getQcList(Qnacomment qc) {
		logger.info("사용자 답글보기");
		return (List<Qnacomment>)QnacomRepo.findAll();
	}
	
	//관리자 답글 상세보기
	@Override
	public Qnacomment getQcDetail(Qnacomment qc) {
		return QnacomRepo.findById(qc.getCcode()).get();
	}
	
	@Override
	public List<Qnacomment> selectQcList() {
		List<Qnacomment> qc = (List<Qnacomment>)QnacomRepo.findAll();
		
		return qc;
		
	}
}

