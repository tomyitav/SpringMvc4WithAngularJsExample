package com.xvitcoder.springmvcangularjs.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.xvitcoder.springmvcangularjs.beans.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train,String> {
}