package com.tsi.library.repository;
// Interface de repositório para a entidade Book, que estende JpaRepository para fornecer métodos de acesso a dados
import org.springframework.data.jpa.repository.JpaRepository;

import com.tsi.library.model.Book;

//Dá automaticamente vários métodos prontos para manipular os dados, como save, findById, findAll, deleteById, etc.
public interface BookRepository extends JpaRepository<Book, Long> {

}