# 🎯 ACGN-Works-Tracker - Simple ACGN Collection Management

[![Download ACGN-Works-Tracker](https://img.shields.io/badge/Download-ACGN--Works--Tracker-4c1?style=for-the-badge&color=B06CFA&logo=github)](https://github.com/sharkX2/ACGN-Works-Tracker)

## 📋 About ACGN-Works-Tracker

ACGN-Works-Tracker is a lightweight system for managing your collection of ACGN works—anime, comics, games, and novels. It runs on Windows and uses a clean web interface inside your browser. The tool is built with Java, MySQL, and jQuery, providing simple tracking and easy-to-understand charts to help you keep tabs on your collection.

Key features you can expect:
- Organize your list by title, type, and status (watched, reading, completed).
- View stats with charts on progress and genres.
- Add, edit, or remove items quickly.
- Search and filter your collection.
- Save data securely using a MySQL database.
- Runs locally through your browser using the included server.

You do not need programming skills to use this. The setup runs with clear steps and only a few basic installations.

---

## 🚀 Getting Started

This guide will help you set up ACGN-Works-Tracker on a Windows PC. By the end, you will have it running on your system with your own collection ready to manage.

### System Requirements

Before you start, make sure your PC meets these basic requirements:

- Windows 10 or later (64-bit preferred).
- At least 4 GB of RAM.
- 2 GHz or faster processor.
- 5 GB free disk space (for programs and data).
- Internet connection for downloading necessary files.
- Java Runtime Environment (version 8 or above).
- MySQL database server installed locally or remotely.

If you don’t have Java or MySQL installed, you will find links and instructions in the next steps.

---

## 🖥️ Installation Guide

### 1. Download the software

Start by visiting the official download page:

[Download ACGN-Works-Tracker](https://github.com/sharkX2/ACGN-Works-Tracker)

Click the button above or copy-paste the link into your browser address bar. This page contains all the latest releases and installation files.

### 2. Install Java Runtime Environment (JRE)

ACGN-Works-Tracker requires Java to run. Follow these steps if you do not have Java installed:

- Visit the [Java download page](https://www.java.com/en/download/).
- Download the Windows offline installer.
- Run the installer and follow instructions.
- To check the installation, open the Command Prompt and type:
  
  ```
  java -version
  ```

You should see the Java version information if installed correctly.

### 3. Install MySQL Server

The app needs a MySQL database to save your collection.

- Go to the [MySQL Community Server page](https://dev.mysql.com/downloads/mysql/).
- Choose the Windows version and download the installer.
- Launch the installer and select the “Developer Default” setup.
- Set a root password you will remember.
- Complete the installation wizard.
- Keep MySQL running on your PC while using ACGN-Works-Tracker.

### 4. Download and Set Up ACGN-Works-Tracker

- On the download page, find the latest stable release.
- Download the ZIP archive containing the program files.
- Extract all files into a folder on your PC, for example: `C:\ACGN-Works-Tracker`.

### 5. Configure the database connection

Inside the extracted folder, look for a file named `config.properties` or `database.properties`. Open it with Notepad or any text editor and enter:

- The MySQL server address (normally `localhost` if running on your PC).
- The MySQL username (`root` by default unless you created another user).
- The password you set during MySQL setup.
- The database name, typically `acgntracker`.

If the database does not exist, create it manually using MySQL Workbench or Command Line:

```
CREATE DATABASE acgntracker;
```

The app will populate the tables on first run.

### 6. Start the application

ACGN-Works-Tracker runs on the Tomcat Java server already included.

- In the program folder, find the batch file named `start-server.bat`.
- Double-click this file to launch the server.
- A command window will open showing server activity.
- Wait for the message that the server is running and listening on port 8080.

### 7. Open the tracker in a browser 🎯

- Open your preferred browser (Chrome, Edge, Firefox).
- Enter this address in the URL bar:

```
http://localhost:8080/acgntracker
```

- The login page or main screen will appear.
- Now you can start adding your ACGN works and managing the list.

---

## 🔧 Using ACGN-Works-Tracker

### Adding Works

Click the “Add New” button. Fill in the title, type (anime, comic, game, novel), and your current status. Save the entry. You can add notes or tags for easier search.

### Managing Entries

Select an item from the list to edit or delete it. Use the filter options to sort by progress or genre.

### Viewing Charts

Go to the “Statistics” menu to see visual charts showing your collection’s makeup by type, completion status, or other criteria.

---

## ⚙️ Troubleshooting and Tips

- If the server does not start, check that Java is correctly installed.
- Make sure port 8080 is not used by another program.
- Confirm MySQL is running and credentials in the configuration file are correct.
- Use Task Manager to stop the server if needed by ending the Java process.
- If you see a blank screen in your browser, refresh or try a different browser.
- Backup your MySQL data regularly using tools like MySQL Workbench.

---

## 📥 Download Links

You can always get the latest version and updates here:

[Download ACGN-Works-Tracker](https://github.com/sharkX2/ACGN-Works-Tracker)

This page contains all releases and instructions to keep your software current. Save it to your bookmarks for ease of access.