package com.drapala.quiz2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ClientsQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Question question;
    private Boolean correctAnswer;
    @ManyToOne
    @JsonIgnore
    private ClientsForm clientsForm;
    private boolean last;

    public ClientsQuestion() {
    }

    public static ClientsQuestion of(Question question, ClientsForm clientsForm) {
        var clientQuestion = new ClientsQuestion();
        clientQuestion.setQuestion(question);
        clientQuestion.setClientsForm(clientsForm);
        return clientQuestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ClientsForm getClientsForm() {
        return clientsForm;
    }

    public void setClientsForm(ClientsForm clientsForm) {
        this.clientsForm = clientsForm;
    }

    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
