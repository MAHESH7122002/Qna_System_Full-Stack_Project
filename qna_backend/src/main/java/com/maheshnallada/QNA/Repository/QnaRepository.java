package com.maheshnallada.QNA.Repository;

import com.maheshnallada.QNA.Model.Qna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QnaRepository extends JpaRepository<Qna,Long>
{

    @Query("SELECT q FROM Qna q WHERE q.user.userId = ?1")
    List<Qna> getQnaByUserId(Long userId);

    @Query("SELECT q FROM Qna q WHERE q.Topic LIKE ?1 ")
    List<Qna> getQnaByTopic(String topic);

    @Query("SELECT DISTINCT q.Topic FROM Qna q")
    List<String> getAllTopics();


}
