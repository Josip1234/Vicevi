package com.jokes.vicevi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="jokes")
public class Jokes {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;

@NotBlank
@Column(unique=true)
private String content;

@ManyToOne
private Category category;

private int likes;
private int dislikes;

public Jokes() {}

public Jokes(Long id,String content, Category category, int likes, int dislikes) {
	
    this.id=id;
	this.content = content;
	this.likes = likes;
	this.category=category;
	this.dislikes = dislikes;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Jokes other = (Jokes) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}