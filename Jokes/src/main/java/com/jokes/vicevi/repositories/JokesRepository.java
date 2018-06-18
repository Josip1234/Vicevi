package com.jokes.vicevi.repositories;




import org.springframework.data.domain.Pageable;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jokes.vicevi.entities.Jokes;

public interface JokesRepository extends JpaRepository<Jokes, Integer>,PagingAndSortingRepository<Jokes, Integer>{

}
