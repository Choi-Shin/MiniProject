package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.choi.board.controller.BoardController;
import com.choi.board.controller.HomeController;
import com.choi.board.controller.MemberController;
import com.choi.board.dataservice.BoardDAO;
import com.choi.board.dataservice.MemberDAO;
import com.choi.board.service.BoardService;
import com.choi.board.service.MemberService;

@Configuration
public class BeanConfig {
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}

	@Bean
	public BoardDAO boardDAO() {
		return new BoardDAO();
	}

	@Bean
	public BoardController boardController() {
		return new BoardController();
	}

	@Bean
	public BoardService boardService() {
		return new BoardService();
	}

	@Bean
	public MemberController memberController() {
		return new MemberController();
	}

	@Bean
	public MemberService memberService() {
		return new MemberService();
	}

	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAO();
	}

}
