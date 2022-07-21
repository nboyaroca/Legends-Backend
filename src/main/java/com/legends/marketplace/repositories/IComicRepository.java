package com.legends.marketplace.repositories;

import com.legends.marketplace.models.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComicRepository extends JpaRepository<Comic, Long> {

}
