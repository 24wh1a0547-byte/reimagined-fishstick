package com.atschecker.ats_checker_backend.service;

import com.atschecker.ats_checker_backend.dto.ATSResponse;
import com.atschecker.ats_checker_backend.util.PdfUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ResumeService {

    public ATSResponse analyzeResume(MultipartFile resume,
                                     String jobDescription) {

        String resumeText = PdfUtil.extractText(resume);

        System.out.println("=========== RESUME ===========");
        System.out.println(resumeText);

        ATSResponse response = new ATSResponse();

        response.setScore(80);

        response.setMatchedSkills(Arrays.asList(
                "Java",
                "Spring Boot"
        ));

        response.setMissingSkills(Arrays.asList(
                "Docker",
                "AWS"
        ));

        response.setSuggestions(Arrays.asList(
                "Learn Docker",
                "Mention AWS Projects"
        ));

        return response;

    }

}