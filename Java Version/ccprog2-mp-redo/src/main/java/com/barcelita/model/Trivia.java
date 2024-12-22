package com.barcelita.model;

public class Trivia {
    private String relation;
    private String relationValue;

    public Trivia(String relation, String relationValue) {
        this.relation = relation;
        this.relationValue = relationValue;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelationValue() {
        return relationValue;
    }

    public void setRelationValue(String relationValue) {
        this.relationValue = relationValue;
    }
}
