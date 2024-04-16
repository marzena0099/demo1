package com.example.demo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UrlRepository extends CassandraRepository<Url, UUID> {
    @AllowFiltering
    Optional<Url> findByShortName(String shortName);
}
