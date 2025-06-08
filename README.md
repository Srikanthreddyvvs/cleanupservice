# 🧹 Cleanup Service

This is a Java-based cleanup utility that finds and moves unwanted scrap files and sends you a mail update.

## 📦 How to Use

### ✅ Requirements
- Java 17+ installed
- Your own Gmail App Password set as environment variables
- Basic knowledge of using Command Prompt

### 🛠️ Setup

1. **Download the latest JAR** from [Releases](https://github.com/Srikanthreddyvvs/cleanupservice/releases/download/v1.0/cleanupservice-0.0.1-SNAPSHOT.jar)
2. **Set the credientials created in Requirements step as System environment variables** on your system:
   - `MAIL_USERNAME=your-app-email@gmail.com`
   - `MAIL_PASSWORD=your-app-password`
Note: the variables and values should be same as above. for example if you gave MAIL_USERNAME as MAIL_ID , it won't work. 
3. **Run this command** in the terminal:
   ```bash
   java -jar cleanupservice-0.0.1-SNAPSHOT.jar your-email@gmail.com


