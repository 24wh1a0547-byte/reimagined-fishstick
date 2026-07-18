package com.atschecker.ats_checker_backend.dto;

import java.util.List;

public class ATSResponse {

    private int score;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private List<String> suggestions;

    public ATSResponse() {
    }

    public ATSResponse(int score,
                       List<String> matchedSkills,
                       List<String> missingSkills,
                       List<String> suggestions) {
        this.score = score;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }
}