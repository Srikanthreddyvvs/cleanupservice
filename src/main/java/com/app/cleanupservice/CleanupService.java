package com.app.cleanupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class CleanupService {
    @Autowired
    private FileScanner fileScanner;
    @Autowired
    private FileMover fileMover;
    @Autowired
    private MailService mailService;

    public void startCleanup() {
        List<File> scrapFiles = fileScanner.getScrapFiles();
        int movedCount = fileMover.moveFiles(scrapFiles);
        mailService.sendCompletionMail(movedCount);
    }
}
