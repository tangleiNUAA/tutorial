package com.vidi.tutorial.pattern.create.builder;

/**
 * @author vidi
 * @date 2018-08-11
 */
public class EducationBackground {
    private String finalDegree;

    private String score;

    public String getFinalDegree() {
        return finalDegree;
    }

    public void setFinalDegree(String finalDegree) {
        this.finalDegree = finalDegree;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "EducationBackground{" +
                "finalDegree='" + finalDegree + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
