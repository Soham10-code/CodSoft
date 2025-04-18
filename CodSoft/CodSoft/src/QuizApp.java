import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizApp {
    private static final int TIME_LIMIT = 10; // Time limit for each question in seconds
    private static List<Question> questions = new ArrayList<>();
    private static int score = 0;
    private static List<Boolean> answers = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize quiz questions
        initializeQuestions();

        // Start the quiz
        startQuiz();

        // Display results
        displayResults();
    }

    private static void initializeQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 1));
        questions.add(new Question("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"1. Charles Dickens", "2. Mark Twain", "3. William Shakespeare", "4. Leo Tolstoy"}, 2));
        questions.add(new Question("What is the chemical symbol for water?", new String[]{"1. O2", "2. H2O", "3. CO2", "4. NaCl"}, 1));
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + question.question);
            for (String option : question.options) {
                System.out.println(option);
            }

            // Start timer for the question
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.");
                    answers.add(false); // No answer given
                }
            };
            timer.schedule(task, TIME_LIMIT * 1000); // Schedule the task

            // Get user input
            System.out.print("Your answer (1-4): ");
            String userInput = scanner.nextLine();
            timer.cancel(); // Cancel the timer if the user answers in time

            // Check if the answer is correct
            if (userInput.matches("[1-4]")) {
                int userAnswerIndex = Integer.parseInt(userInput) - 1;
                answers.add(userAnswerIndex == question.correctAnswerIndex);
                if (userAnswerIndex == question.correctAnswerIndex) {
                    score++;
                }
            } else {
                System.out.println("Invalid input. No answer recorded.");
                answers.add(false); // No answer given
            }
        }
        scanner.close();
    }

    private static void displayResults() {
        System.out.println("\nQuiz Finished!");
        System.out.println("Your final score: " + score + " out of " + questions.size());
        System.out.println("Summary of your answers:");
        

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("Question " + (i + 1) + ": " + (answers.get(i) ? "Correct" : "Incorrect"));
        }
        
    }
}