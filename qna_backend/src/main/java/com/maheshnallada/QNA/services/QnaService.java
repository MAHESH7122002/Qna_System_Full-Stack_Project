package com.maheshnallada.QNA.services;

import com.maheshnallada.QNA.Repository.QnaRepository;
import com.maheshnallada.QNA.dto.QnaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QnaService
{
    QnaDto createQNA(QnaDto qnaDto);

    QnaDto getQnaById(Long qnaId);


    List<QnaDto> getAllQna();




}
