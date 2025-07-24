import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ResumeMatcher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter path to job description file: ");
        String jobDescPath = scanner.nextLine();

        try {
            // Read job description
            String jobDescription = Files.readString(Paths.get(jobDescPath)).toLowerCase();
            Set<String> jobWords = new HashSet<>(Arrays.asList(jobDescription.split("\\W+")));

            // Path to resumes folder
            File resumeFolder = new File("resumes/");
            File[] resumeFiles = resumeFolder.listFiles((dir, name) -> name.endsWith(".txt"));

            if (resumeFiles == null || resumeFiles.length == 0) {
                System.out.println("No resumes found in the 'resumes/' folder.");
                return;
            }

            System.out.println("\nMatching resumes to job description...\n");

            Map<String, Integer> scoreMap = new HashMap<>();

            for (File resume : resumeFiles) {
                String resumeText = Files.readString(resume.toPath()).toLowerCase();
                Set<String> resumeWords = new HashSet<>(Arrays.asList(resumeText.split("\\W+")));

                // Calculate match score
                int matchCount = 0;
                for (String word : resumeWords) {
                    if (jobWords.contains(word)) {
                        matchCount++;
                    }
                }

                int score = (int) (((double) matchCount / jobWords.size()) * 100);
                scoreMap.put(resume.getName(), score);
                System.out.println("Score for " + resume.getName() + ": " + score + "%");
            }

            // Find top match
            String topResume = Collections.max(scoreMap.entrySet(), Map.Entry.comparingByValue()).getKey();
            int topScore = scoreMap.get(topResume);

            System.out.println("\nTop matching resume: " + topResume + " with score " + topScore + "%");

        } catch (IOException e) {
            System.out.println("Error reading file. Please check the path and try again.");
        }
    }
}
