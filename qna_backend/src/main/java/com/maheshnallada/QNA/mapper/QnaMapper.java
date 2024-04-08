package com.maheshnallada.QNA.mapper;


import com.maheshnallada.QNA.Model.Qna;
import com.maheshnallada.QNA.dto.QnaDto;

public class QnaMapper {
    public static QnaDto mapToQnaDto(Qna qna) {
        QnaDto qnaDto = new QnaDto();
        qnaDto.setQnaId(qna.getQnaId());
        qnaDto.setUserId(qna.getUser().getUserId()); // Set userId from User object
        qnaDto.setQuestion(qna.getQuestion());
        qnaDto.setAnswer(qna.getAnswer());
        qnaDto.setLevel(qna.getLevel());
        qnaDto.setTopic(qna.getTopic());
        return qnaDto;
    }

    public static Qna mapToQna(QnaDto qnaDto) {
        Qna qna = new Qna();
        qna.setQnaId(qnaDto.getQnaId());
        // Set other fields except user, as the user will be set separately in the service layer
        qna.setQuestion(qnaDto.getQuestion());
        qna.setAnswer(qnaDto.getAnswer());
        qna.setLevel(qnaDto.getLevel());
        qna.setTopic(qnaDto.getTopic());
        return qna;
    }

    public static QnaDto mapToTopicDto(Qna qna)
    {
        QnaDto qnaDto = new QnaDto();
        qnaDto.setTopic(qna.getTopic());
        return qnaDto;
    }

    public static Qna mapToTopic(QnaDto qnaDto)
    {
        Qna qna = new Qna();
        qna.setTopic(qnaDto.getTopic());
        return qna;
    }

}