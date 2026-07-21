package com.atschecker.ats_checker_backend.service;

import com.atschecker.ats_checker_backend.dto.ATSResponse;
import com.atschecker.ats_checker_backend.util.PdfUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ResumeService {

    public ATSResponse analyzeResume(MultipartFile resume,
                                     String jobDescription) {

        String resumeText = PdfUtil.extractText(resume);

        Map<String, Object> result =
                ATSAnalyzer.analyze(resumeText, jobDescription);

        ATSResponse response = new ATSResponse();

        response.setScore((Integer) result.get("score"));
        response.setMatchedSkills((List<String>) result.get("matchedSkills"));
        response.setMissingSkills((List<String>) result.get("missingSkills"));
        response.setSuggestions((List<String>) result.get("suggestions"));

        return response;
    }
}