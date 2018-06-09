package com.jokes.vicevi.entities;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="category")
public class Category {
	
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@NotBlank
@Column(unique=true)
private String name;

@OneToMany(mappedBy="category")
private List<Jokes> vicevi;

public Category() {}

public Category(Long id,String name) {
	
    this.id=id;
	this.name = name;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}






}
