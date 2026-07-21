package com.atschecker.ats_checker_backend.service;

import com.atschecker.ats_checker_backend.util.SkillsDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATSAnalyzer {

    public static Map<String, Object> analyze(String resumeText, String jobDescription) {

        resumeText = resumeText.toLowerCase();
        jobDescription = jobDescription.toLowerCase();

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String skill : SkillsDatabase.SKILLS) {

            boolean required = jobDescription.contains(skill);
            boolean available = resumeText.contains(skill);

            if (required && available) {
                matchedSkills.add(skill);
            }

            if (required && !available) {
                missingSkills.add(skill);
            }
        }

        int totalSkills = matchedSkills.size() + missingSkills.size();

        int score = 0;

        if (totalSkills > 0) {
            score = (matchedSkills.size() * 100) / totalSkills;
        }

        List<String> suggestions = new ArrayList<>();

        for (String skill : missingSkills) {
            suggestions.add("Add " + skill + " to your resume if you have experience with it.");
        }

        Map<String, Object> result = new HashMap<>();

        result.put("score", score);
        result.put("matchedSkills", matchedSkills);
        result.put("missingSkills", missingSkills);
        result.put("suggestions", suggestions);

        return result;
    }
}