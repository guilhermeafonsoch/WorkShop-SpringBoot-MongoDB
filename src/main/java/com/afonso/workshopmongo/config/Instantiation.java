package com.afonso.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.afonso.workshopmongo.domain.Post;
import com.afonso.workshopmongo.domain.User;
import com.afonso.workshopmongo.repository.PostRepository;
import com.afonso.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private PostRepository postpository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userrepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem","Vou viajar para São Paulo. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia","Acordei Feliz Hoje", maria);
		
		userrepository.saveAll(Arrays.asList(maria,alex,bob));
		postpository.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
