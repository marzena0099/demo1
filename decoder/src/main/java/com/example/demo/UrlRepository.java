package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortName(String shortName);
}
