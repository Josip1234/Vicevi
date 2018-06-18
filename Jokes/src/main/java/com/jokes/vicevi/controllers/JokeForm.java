package com.jokes.vicevi.controllers;




import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jokes.vicevi.entities.Category;
import com.jokes.vicevi.entities.Jokes;
import com.jokes.vicevi.repositories.CategoryRepository;
import com.jokes.vicevi.repositories.JokesRepository;



@Controller
public class JokeForm implements WebMvcConfigurer {
	
	private CategoryRepository categoryRepository;
	private  JokesRepository jokesRepo;
	
	 @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("/");
	    }
	
	@Autowired
	public JokeForm(JokesRepository jokesRepository,CategoryRepository categoryRepo) {
		this.categoryRepository=categoryRepo;
		this.jokesRepo=jokesRepository;
	}
	
	
	
	/*@GetMapping("/")
    public String dohvatiListuViceva(Model model) {
		List<Jokes> listaViceva= jokesRepo.findAll();
		
		
	   
	    Collections.sort(listaViceva,Jokes.sortirajPoRazlici);
       
	    model.addAttribute("vicevi",listaViceva);
	  
		return "index";
	}
	@GetMapping("/index")
    public String ograničiListuViceva(Pageable pageable,Model model) {
		Page<Jokes> listaViceva=jokesRepo.findAll(pageable);
		pageable=PageRequest.of(0, 3);
		
	   
	   
       
	    model.addAttribute("vicevi",listaViceva);
	  
		return "index";
	}*/
	@GetMapping("/")
    public String ograničiListuViceva(Model model) {
		
			Pageable pageable=PageRequest.of(0, 10);
			Page<Jokes> listaViceva=jokesRepo.findAll(pageable);
			model.addAttribute("vicevi",listaViceva);
		
		
		
		
	   
	   
       
	  
	  
		return "index";
	}
	@GetMapping("/index/{id}")
	public String dohvatiLikeIDislike(@RequestParam Integer id ,@RequestParam(value="like",defaultValue="0") int like,@RequestParam(value="dislike",defaultValue="0") int dislike,Model model) {
		//System.out.println(id);
		//System.out.println(String.valueOf(like));
		//System.out.println(String.valueOf(dislike));
		Jokes jk = new Jokes();
		jk=jokesRepo.getOne(id);
		//System.out.println("Stare vrijednosti:\n"+jk.getId()+" "+jk.getCategory()+" "+jk.getContent()+" "+jk.getLikes()+" "+jk.getDislikes());
		jk.setLikes(jk.getLikes()+like);
		jk.setDislikes(jk.getDislikes()+dislike);
		//System.out.println("Nove vrijednosti:\n"+jk.getId()+" "+jk.getCategory()+" "+jk.getContent()+" "+jk.getLikes()+" "+jk.getDislikes());
		jokesRepo.save(jk);
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
		    /* System.out.println(jokes.getId());
		     System.out.println(category.getId());
		     System.out.println(category.getName());
		     System.out.println(jokes.getContent());*/
		     if(bindingResult.hasErrors()) {
		    	 return "new";
		     }
		     jokesRepo.save(jokes);
	        return "redirect:/";
	    }
	 
	 

}
