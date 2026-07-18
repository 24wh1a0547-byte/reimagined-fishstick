package com.atschecker.ats_checker_backend.controller;

import com.atschecker.ats_checker_backend.dto.ATSResponse;
import com.atschecker.ats_checker_backend.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:5173")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/analyze")
    public ATSResponse analyzeResume(
            @RequestParam("resume") MultipartFile resume,
            @RequestParam("jobDescription") String jobDescription
    ) {

        return resumeService.analyzeResume(resume, jobDescription);
    }
}