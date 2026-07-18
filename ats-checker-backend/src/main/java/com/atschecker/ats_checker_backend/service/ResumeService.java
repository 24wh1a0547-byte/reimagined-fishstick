package com.atschecker.ats_checker_backend.service;

import com.atschecker.ats_checker_backend.dto.ATSResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Service
public class ResumeService {

    public ATSResponse analyzeResume(MultipartFile resume,
                                     String jobDescription) {

        ATSResponse response = new ATSResponse();

        response.setScore(80);

        response.setMatchedSkills(
                Arrays.asList("Java", "Spring Boot")
        );

        response.setMissingSkills(
                Arrays.asList("Docker", "AWS")
        );

        response.setSuggestions(
                Arrays.asList(
                        "Mention Docker",
                        "Add AWS Project"
                )
        );

        return response;
    }

}