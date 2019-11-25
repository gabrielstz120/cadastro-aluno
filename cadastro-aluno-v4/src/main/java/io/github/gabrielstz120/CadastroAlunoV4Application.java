package io.github.gabrielstz120;

import io.github.gabrielstz120.views.Sistema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroAlunoV4Application implements CommandLineRunner {

	@Autowired
	private Sistema sistema;

	public static void main(String[] args) {
		SpringApplication.run(CadastroAlunoV4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sistema.initSystem();
	}
}
