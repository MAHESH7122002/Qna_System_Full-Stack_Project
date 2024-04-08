package com.maheshnallada.QNA.services;

import com.maheshnallada.QNA.Model.Qna;
import com.maheshnallada.QNA.Model.User;
import com.maheshnallada.QNA.Repository.QnaRepository;
import com.maheshnallada.QNA.Repository.UserRepository;
import com.maheshnallada.QNA.dto.QnaDto;
import com.maheshnallada.QNA.exception.ResourceNotFoundException;
import com.maheshnallada.QNA.mapper.QnaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QnaServiceImpl implements QnaService {

    @Autowired
    private QnaRepository qnaRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public QnaDto createQNA(QnaDto qnaDto) {
        User user = userRepository.findById(qnaDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + qnaDto.getUserId()));

        Qna qna = QnaMapper.mapToQna(qnaDto);
        qna.setUser(user); // Set the user for the Qna object

        Qna savedQna = qnaRepository.save(qna);

        return QnaMapper.mapToQnaDto(savedQna);
    }

    @Override
    public QnaDto getQnaById(Long qnaId)
    {
        Qna qna = qnaRepository.findById(qnaId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Qna not exist with id :" + qnaId)
                );
        return  QnaMapper.mapToQnaDto(qna);
    }


    @Override
    public List<QnaDto> getAllQna()
    {
        List<Qna> qnas = qnaRepository.findAll();
        return qnas.stream().map(qna -> QnaMapper.mapToQnaDto(qna))
                .collect(Collectors.toList());
    }

}
