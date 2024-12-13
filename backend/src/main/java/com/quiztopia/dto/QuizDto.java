package com.quiztopia.dto;

import java.util.List;

public class QuizDto {

    private Long id;
    private String title;
    private String description;
    private List<Long> questionIds;  // List of question IDs (or detailed question data if necessary)

    // Constructors
    public QuizDto() {
    }

    public QuizDto(Long id, String title, String description, List<Long> questionIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questionIds = questionIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<Long> questionIds) {
        this.questionIds = questionIds;
    }
}