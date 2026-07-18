package com.atschecker.ats_checker_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {

    @GetMapping("/api/test")
    public String test() {
        return "ATS Backend is Working!";
    }

}