package poly.service;

import java.util.List;

import poly.dto.BoardDTO;

public interface IBoardService {
	
	int insertBoardInfo(BoardDTO bDTO) throws Exception;

	List<BoardDTO> getBoardList() throws Exception;

	BoardDTO getBoardDetail(String seq) throws Exception;

	int updateBoard(BoardDTO bDTO) throws Exception;

	int deleteBoard(String seq);
	
	
}
