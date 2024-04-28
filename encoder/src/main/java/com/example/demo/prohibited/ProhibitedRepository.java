package com.example.demo.prohibited;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ProhibitedRepository extends CassandraRepository<Prohibited, UUID> {
    @AllowFiltering
    Boolean existsByWord(String word);

}
