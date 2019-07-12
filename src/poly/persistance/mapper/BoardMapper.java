package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDTO;

@Mapper("BoardMapper")
public interface BoardMapper {
	List<BoardDTO> getBoardList() throws Exception;

	BoardDTO getBoardDetail(String seq) throws Exception;

	int insertBoardInfo(BoardDTO bDTO) throws Exception;
	
	int updateBoard(BoardDTO bDTO) throws Exception;

	int deleteBoard(String seq);
	
}
