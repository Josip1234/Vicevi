package com.jokes.vicevi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jokes.vicevi.entities.Category;
import com.jokes.vicevi.entities.Jokes;
import com.jokes.vicevi.repositories.CategoryRepository;
import com.jokes.vicevi.repositories.JokesRepository;

@Controller
public class JokeForm {
	
	private CategoryRepository categoryRepository;
	private JokesRepository jokesRepo;
	
	@Autowired
	public JokeForm(JokesRepository jokesRepository,CategoryRepository categoryRepo) {
		this.categoryRepository=categoryRepo;
		this.jokesRepo=jokesRepository;
	}
	 @GetMapping("/new")
	    public String greetingForm(Model model) {
	        model.addAttribute("jokes", new Jokes());
	        List<Category> lista=categoryRepository.findAll();
	        model.addAttribute("kategorija",lista);
	        return "new";
	    }
	 @PostMapping("/new")
	    public String greetingSubmit(@ModelAttribute Jokes jokes,@ModelAttribute Category category) {
		    
		    
		    jokesRepo.save(jokes);
	        return "new";
	    }
}
