package org.generation.LojaDeGames.repository;

import java.util.List;

import org.generation.LojaDeGames.model.Cetegoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CetegoriaRepository extends JpaRepository<Cetegoria, Long>
{
public List<Cetegoria> findAllByJogosContainingIgnoreCase (String Jogos);
}
