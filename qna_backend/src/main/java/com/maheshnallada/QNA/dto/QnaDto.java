package com.maheshnallada.QNA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QnaDto
{
    private long QnaId;
    private long userId;
    private String Question;
    private String Answer;
    private String Level;
    private String Topic;


}
