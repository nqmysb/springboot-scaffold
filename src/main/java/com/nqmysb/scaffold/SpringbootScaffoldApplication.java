package com.nqmysb.scaffold;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.nqmysb.scaffold.mapper.*.*")
@ServletComponentScan
public class SpringbootScaffoldApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootScaffoldApplication.class, args);
	}

}
