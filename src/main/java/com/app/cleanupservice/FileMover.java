package com.app.cleanupservice;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileMover {
    public int moveFiles(List<File> scrapFiles) {
        int count = 0;
        String binPath = System.getProperty("user.home") + File.separator + "RecycleBinCleanup";
        File binFolder = new File(binPath);
        if (!binFolder.exists()) {
            binFolder.mkdirs();
        }

        for (int i = 0; i < scrapFiles.size(); i++) {
            File file = scrapFiles.get(i);
            String newName = file.getName()+"_"+System.currentTimeMillis();
            File dest = new File(binFolder, newName);
            boolean success = file.renameTo(dest);
            if (success) {
                System.out.println("Moved: " + file.getName());
                count++;
            }else{
                System.out.println("Failed to move: " + file.getName());
            }
        }

        return count;
    }
}
