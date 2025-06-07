package com.app.cleanupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class CleanupApp implements CommandLineRunner {
	@Autowired
	private CleanupService cleanupService;

	public static void main(String[] args) {
		SpringApplication.run(CleanupApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cleanupService.startCleanup();
	}
}
