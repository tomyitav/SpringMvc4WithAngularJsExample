//package com.xvitcoder.springmvcangularjs.dao;
//
//import org.mongodb.morphia.Morphia;
//import org.mongodb.morphia.dao.BasicDAO;
//
//import com.mongodb.MongoClient;
//import com.xvitcoder.springmvcangularjs.beans.Train;
//
//public class TrainDAO extends BasicDAO<Train, String>{
//	
//	static MongoClient mongo = new MongoClient( "localhost" , 27017 );
//	static Morphia morphia = new Morphia();
//	static String dbname = "trains";
//	
//	public TrainDAO() {
//		super(mongo, morphia, dbname);
//	}
//}
