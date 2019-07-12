package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.BoardDTO;
import poly.service.IBoardService;

@Controller
public class BoardController {

		private Logger log = Logger.getLogger(this.getClass());
		

		@RequestMapping(value="/board/boardList")
		public String BoardList(Model model) {
			log.info(this.getClass().getName());
			
			List<BoardDTO> bList = new ArrayList<>();
			
			try {
				bList = boardService.getBoardList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("bList", bList);
			
			return "board/boardList";
		}
		
		
		@RequestMapping(value="/board/boardReg")
		public String RegBoard() {
			log.info(this.getClass().getName());
			
			return "/board/boardReg";
		}
		
		@RequestMapping(value="board/boardRegProc")
		public String BoardRegProc(HttpServletRequest request, Model model) {
			log.info(this.getClass().getName());
			
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			String userSeq = request.getParameter("userSeq"); //추가된 부분 - 아직 이용되지 않았음
			
			log.info(title);
			log.info(contents);
			
			BoardDTO bDTO = new BoardDTO();
			bDTO.setContent(contents);
			bDTO.setTitle(title);
			
			int result = 0;
			
			try {
				result= boardService.insertBoardInfo(bDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
			model.addAttribute("url", "/board/boardList.do");
			model.addAttribute("msg", "등록되었습니다.");
			} else {
				model.addAttribute("url", "/board/boardReg.do");
				model.addAttribute("msg", "등록에 실패했습니다.");
			}
			return "/redirect";
		}

		
		@RequestMapping(value="board/boardDetail")
		public String boardDetail(HttpServletRequest request, Model model) {
			log.info(this.getClass().getName());
			
			String seq = request.getParameter("seq");
			
			BoardDTO bDTO = new BoardDTO();
			
			try {
				bDTO = boardService.getBoardDetail(seq);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("bDTO", bDTO);
			return "board/boardDetail";
		}
		
		@RequestMapping(value="board/boardModify")
		public String BoardModify(HttpServletRequest request, Model model) {
			log.info(this.getClass().getName());
			
			String seq = request.getParameter("seq");
			
			BoardDTO bDTO = new BoardDTO();
			
			try {
				bDTO = boardService.getBoardDetail(seq);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("bDTO", bDTO);
			
			return "board/boardModify";
		}
		
		@RequestMapping(value="board/boardModifyProc")
		public String BoardModifyProc(HttpServletRequest request, Model model) {
			log.info(this.getClass().getName());
			
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			String seq = request.getParameter("seq");
			
			log.info(this.getClass() + " title : " + title);
			log.info(this.getClass() + " contents : " + contents);
			log.info(this.getClass() + " seq : " + seq);
			
			BoardDTO bDTO = new BoardDTO();
			bDTO.setContent(contents);
			bDTO.setSeq(seq);
			bDTO.setTitle(title);
			
			int result = 0;
			
			try {
				result= boardService.updateBoard(bDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result > 0) {
				model.addAttribute("msg", "수정되었습니다.");
				model.addAttribute("url", "/board/boardDetail.do?seq="+seq);
			
			} else {
				model.addAttribute("msg", "수정에 실패했습니다.");
				model.addAttribute("url", "/board/boardDetail.do?seq="+seq);
			}
			return "redirect";
		}
		
		@RequestMapping(value="board/boardDelete")
		public String boardDelete(HttpServletRequest request, Model model)  {
			log.info(this.getClass().getName());
			
			String seq = request.getParameter("seq");
			
			int result=0;
			result = boardService.deleteBoard(seq);
			
			if(result>0) {
				model.addAttribute("msg", "삭제되었습니다.");
				model.addAttribute("url", "/board/boardList.do");
			} else {
				model.addAttribute("msg", "삭제 실패했습니다.");
				model.addAttribute("url", "/board/boardList.do");
			}
			
			return "redirect";
		}
		
		@Resource(name="BoardService")
		private IBoardService boardService;
}
		
