package com.app.cleanupservice;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileScanner {
    private List<String> pathsToScan;

    public FileScanner() {
        pathsToScan = new ArrayList<String>();
        String userHome = System.getProperty("user.home");

        pathsToScan.add(userHome + File.separator + "Downloads");
        pathsToScan.add(userHome + File.separator + "Desktop");
        pathsToScan.add(System.getenv("TEMP"));
        pathsToScan.add("C:\\Windows\\Temp");  // can add Mac/Linux equivalents later
    }

    public List<File> getScrapFiles() {
        List<File> scrapFiles = new ArrayList<File>();
        for (int i = 0; i < pathsToScan.size(); i++) {
            File folder = new File(pathsToScan.get(i));
            if (folder.exists()) {
                scanFolder(folder, scrapFiles);
            }
        }
        return scrapFiles;
    }

    private void scanFolder(File folder, List<File> scrapFiles) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isFile() && isScrap(file)) {
                scrapFiles.add(file);
            } else if (file.isDirectory()) {
                scanFolder(file, scrapFiles);
            }
        }
    }

    private boolean isScrap(File file) {
        String name = file.getName().toLowerCase();

        // Check extensions
        boolean isOldExtension = name.endsWith(".log") || name.endsWith(".tmp") ||
                name.endsWith(".bak") || name.endsWith(".old");

        if (isOldExtension) {
            return true;  // scrap due to extension
        }

        // Check age - 180 days = 6 months approx
        long lastModified = file.lastModified(); // milliseconds since epoch
        long currentTime = System.currentTimeMillis();

        long daysOld = (currentTime - lastModified) / (1000 * 60 * 60 * 24);
        if (daysOld >= 180) {
            return true;  // scrap due to age (not used for 6+ months)
        }

        return false;  // not scrap
    }
}
