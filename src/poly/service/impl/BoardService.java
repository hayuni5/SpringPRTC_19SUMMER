package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BoardDTO;
import poly.persistance.mapper.BoardMapper;
import poly.service.IBoardService;

@Service("BoardService")
public class BoardService implements IBoardService {
	
	@Resource(name="BoardMapper")
	private BoardMapper boardMapper;
	
	@Override
	public int insertBoardInfo(BoardDTO bDTO) throws Exception {
		return boardMapper.insertBoardInfo(bDTO);
	}

	@Override
	public List<BoardDTO> getBoardList() throws Exception {
		return boardMapper.getBoardList();
	}

	@Override
	public BoardDTO getBoardDetail(String seq) throws Exception {
		return boardMapper.getBoardDetail(seq);
	}

	@Override
	public int updateBoard(BoardDTO bDTO) throws Exception {
		return boardMapper.updateBoard(bDTO);
	}

	@Override
	public int deleteBoard(String seq) {
		return boardMapper.deleteBoard(seq);
	}

}

