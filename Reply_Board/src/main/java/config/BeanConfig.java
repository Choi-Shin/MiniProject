package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.choi.board.controller.BoardController;
import com.choi.board.controller.HomeController;

@Configuration
public class BeanConfig {
	@Bean
	public BoardController AnyControl( ) {
		return new BoardController( );
	}
	
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}

}
