package com.jokes.vicevi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jokes.vicevi.entities.Category;
import com.jokes.vicevi.entities.Jokes;
import com.jokes.vicevi.repositories.CategoryRepository;
import com.jokes.vicevi.repositories.JokesRepository;

@Controller
public class JokeForm implements WebMvcConfigurer {
	
	private CategoryRepository categoryRepository;
	private JokesRepository jokesRepo;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("/");
	    }
	
	@Autowired
	public JokeForm(JokesRepository jokesRepository,CategoryRepository categoryRepo) {
		this.categoryRepository=categoryRepo;
		this.jokesRepo=jokesRepository;
	}
	@GetMapping("/")
	public String dohvatiListuViceva(Model model) {
		List<Jokes> listaViceva=jokesRepo.findAll();
		model.addAttribute("vicevi",listaViceva);
		return "index";
	}
	 @GetMapping("/new")
	    public String dohvatiObrazac(Model model) {
	        model.addAttribute("jokes", new Jokes());
	        List<Jokes> joke=jokesRepo.findAll();
	        List<Category> lista=categoryRepository.findAll();
	        model.addAttribute("kategorija",lista);
	        model.addAttribute("vicevi",joke);
	       
	        return "new";
	    }
	 @PostMapping("/new")
	    public String unesiNoviVic(@Valid  Jokes jokes,@Valid Category category,BindingResult bindingResult) {
		     System.out.println(jokes.getId());
		     System.out.println(category.getId());
		     System.out.println(category.getName());
		     System.out.println(jokes.getContent());
		     if(bindingResult.hasErrors()) {
		    	 return "new";
		     }
		     jokesRepo.save(jokes);
	        return "redirect:/";
	    }
}
