package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.choi.board.controller.BoardController;
import com.choi.board.controller.HomeController;
import com.choi.board.controller.MemberController;
import com.choi.board.dataservice.BoardDAO;
import com.choi.board.service.BoardService;

@Configuration
public class BeanConfig {
	@Bean
	public BoardController boardController() {
		return new BoardController();
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}

	@Bean
	public MemberController memberController() {
		return new MemberController();
	}

	@Bean
	public BoardDAO boardDAO() {
		return new BoardDAO();
	}

	@Bean
	public BoardService boardService() {
		return new BoardService();
	}
}
