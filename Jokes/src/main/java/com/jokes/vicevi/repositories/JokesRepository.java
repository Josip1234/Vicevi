package com.jokes.vicevi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jokes.vicevi.entities.Jokes;

public interface JokesRepository extends JpaRepository<Jokes, Integer> {

}
