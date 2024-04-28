package com.example.demo.url;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
interface UrlRepository extends CassandraRepository<Url, UUID> {
    @AllowFiltering
    Optional<Url> findByShortName(String shortName);

    @AllowFiltering
    List<Url> findAllByCreatedLessThan(Instant date);
}
