package com.tsi.library.repository;
// Interface de repositório para a entidade Author, que estende JpaRepository para fornecer métodos de acesso a dados
import org.springframework.data.jpa.repository.JpaRepository;

import com.tsi.library.model.Author;
//Dá automaticamente vários métodos prontos para manipular os dados, como save, findById, findAll, deleteById, etc.
public interface AuthorRepository extends JpaRepository<Author, Long> {

}