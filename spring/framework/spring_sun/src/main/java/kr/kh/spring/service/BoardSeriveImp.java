package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.BoardDAO;

@Service
public class BoardSeriveImp  implements BoardSerive{

	@Autowired
	private BoardDAO boardDAO; //DAO는 어노테이션 안달아도 되는 이유 -> root-context에서 인식하도록 설정함

}
	
