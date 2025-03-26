package com.pracatice.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pracatice.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{

	List<Question> findByCategory(String category);
	//String addQuestion(Question question);

	/*@Query(value="SELECT * FROM question q where q.category=:category Order By RAND() Limit ?1",nativeQuery=true)
	List<Question> findRandmQuesBycategory(String category, int numQ);*/
	
	/*@Query(value="SELECT * FROM question q where q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	List<Question> findRandmQuesBycategory(String category, int numQ);*/

	
	@Query(value="SELECT * FROM question q WHERE q.category=:category ORDER BY RAND()", nativeQuery=true)
	List<Question> findRandmQuesBycategory(@Param("category") String category);

}
