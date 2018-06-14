package com.jokes.vicevi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;



@Entity
@Table(name="jokes")
public class Jokes {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private Integer id;


@NotBlank
@Column(unique=true)
private String content;

@ManyToOne
private Category category;

private int likes;
private int dislikes;

public Jokes() {}

public Jokes(Integer id,String content, Category category, int likes, int dislikes) {
	
    this.id=id;
	this.content = content;
	this.likes = likes;
	this.category=category;
	this.dislikes = dislikes;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public int getLikes() {
	return likes;
}

public void setLikes(int likes) {
	this.likes = likes;
}

public int getDislikes() {
	return dislikes;
}

public void setDislikes(int dislikes) {
	this.dislikes = dislikes;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}




}
