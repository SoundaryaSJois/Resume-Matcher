# Resume Matcher - Java CLI Project

A command-line Java application that helps match resumes against a given job description by computing keyword relevance. Useful for quick shortlisting based on basic textual matching.

## Features

- Accepts a job description text file and a folder of resume files (in `.txt` format).
- Calculates keyword overlap between the job description and each resume.
- Outputs similarity scores and ranks resumes based on relevance.


## How It Works

1. **Input**: Path to job description file and folder containing resumes.
2. **Processing**:
   - Cleans and tokenizes text.
   - Counts keyword frequency and computes similarity.
3. **Output**: Prints ranked list of resumes with similarity scores in terminal.


## Sample Output

> You will be prompted like this:
Enter path to job description file:
Enter path to folder containing resumes:

> And the output will look like this:
Similarity Scores:
resume1.txt : 78.0%
resume3.txt : 62.5%
resume2.txt : 45.0%
resume4.txt : 32.0%


## Folder Structure

Resume-Matcher/
├── ResumeMatcher.java
├── README.md
├── .gitignore
├── jobs/
│ ├── job1.txt
│ └── job2.txt
├── resumes/
│ ├── resume1.txt
│ ├── resume2.txt
│ ├── resume3.txt
│ └── resume4.txt
└── Screenshots/
├── op1.png
└── op2.png


## Skills Used

- Java (File I/O, Strings, HashMaps)
- CLI-based user interaction
- Basic NLP (tokenization, frequency matching)
- Git & GitHub for version control


##  To Run This Project

javac ResumeMatcher.java
java ResumeMatcher

Make sure your job description and resume files are in .txt format.

Motivation:

This project simulates a simple version of an ATS (Applicant Tracking System). It helped me understand how resumes can be filtered using text-matching logic and built my confidence in writing full CLI apps in Java.
