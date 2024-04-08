package com.maheshnallada.QNA.controller;


import com.maheshnallada.QNA.Model.Qna;
import com.maheshnallada.QNA.Repository.QnaRepository;
import com.maheshnallada.QNA.Repository.UserRepository;
import com.maheshnallada.QNA.dto.QnaDto;
import com.maheshnallada.QNA.mapper.QnaMapper;
import com.maheshnallada.QNA.services.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class QnaController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QnaRepository qnaRepository;

    @Autowired
    private QnaService qnaService;

    //Create Question and answers
//    @PreAuthorize("hasRole{'ROLE_ADMIN'}")
    @PostMapping("/qna")
    public ResponseEntity<QnaDto> createQna(@RequestBody QnaDto qnaDto)
    {
        QnaDto savedQna = qnaService.createQNA(qnaDto);
        return new ResponseEntity<>(savedQna, HttpStatus.CREATED);
    }


    //Retrieve the Data by QnaId
    @GetMapping("/{id}")
    public ResponseEntity<QnaDto> getQnaById(@PathVariable("id") Long qnaId)
    {
        QnaDto qnaDto = qnaService.getQnaById(qnaId);
        return ResponseEntity.ok(qnaDto);
    }

    //Filter the Qnas by User Id
    @GetMapping("user/{id}")
    public ResponseEntity<List<QnaDto>> getQnaByUserId(@PathVariable("id") Long userId)
    {
        List<QnaDto> qnaDto = qnaRepository.getQnaByUserId(userId)
                .stream().map(qna -> QnaMapper.mapToQnaDto(qna))
                .collect(Collectors.toList());
        return ResponseEntity.ok(qnaDto);
    }

    //Retrieve all Qnas
    @GetMapping("/qnas")
    public ResponseEntity<List<QnaDto>> getAllQnas()
    {
        List<QnaDto> qnaDtos = qnaService.getAllQna();
        return ResponseEntity.ok(qnaDtos);
    }

    //Retrieve all Qnas by topic

    @GetMapping("qnas/topic/{topic}")
    public ResponseEntity<List<QnaDto>> getQnaByTopic(@PathVariable("topic") String topic) {
        List<QnaDto> qnaDtoList = qnaRepository.getQnaByTopic(topic)
                .stream()
                .map(QnaMapper::mapToQnaDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(qnaDtoList);
    }
    @GetMapping("qna/topics")
    public ResponseEntity<List<String>> getAllTopics() {
        List<String> topics = qnaRepository.getAllTopics();
        return ResponseEntity.ok(topics);
    }

}
