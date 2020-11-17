package hh.swd20.Tournament;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Tournament.webcontroller.TeamController;
import hh.swd20.Tournament.webcontroller.PlayerController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private TeamController tController;
	@Autowired
	private PlayerController pController;
	
	@Test
	void ControllersTest() {
		
		assertThat(tController).isNotNull();
		assertThat(pController).isNotNull();
		
	}
	


		
		
	

}
