package com.maheshnallada.QNA.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Qna")
public class Qna
{
    @Id
    @SequenceGenerator(
            name="Qna_Sequence",
            sequenceName = "Qna_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Qna_Sequence")
    @Column(name="QnaId")
    private long QnaId;

    // Many-to-one relationship with User entity
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "Question")
    private String Question;

    @Column(name="Answer")
    private String Answer;

    @Column(name="Topic")
    private String Topic;

    @Column(name="Level")
    private String Level;



}
