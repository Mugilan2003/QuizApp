package practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private char correctOption;

    public Question(String questionText, List<String> options, char correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println("\n" + questionText);
        char label = 'A';
        for (String option : options) {
            System.out.println(label + ". " + option);
            label++;
        }
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(correctOption);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questionList = new ArrayList<>();

        questionList.add(new Question("What is the capital of India?",
                List.of("New Delhi", "Mumbai", "Chennai", "Kolkata"), 'A'));

        questionList.add(new Question("Which keyword is used to define a class in Java?",
                List.of("define", "class", "struct", "new"), 'B'));

        questionList.add(new Question("Which of these is a loop structure?",
                List.of("if", "else", "while", "switch"), 'C'));

        questionList.add(new Question("Java is ___?",
                List.of("Procedural", "Functional", "Object-Oriented", "None"), 'C'));

        questionList.add(new Question("Which method is entry point in Java program?",
                List.of("start()", "run()", "main()", "init()"), 'C'));
        
        questionList.add(new Question("Which data type is used to store decimal numbers in Java?",
                List.of("int", "float", "char", "boolean"), 'B'));

        questionList.add(new Question("Which symbol is used to inherit a class in Java?",
                List.of(":", "->", "extends", "implements"), 'C'));

        questionList.add(new Question("Which of the following is not a Java access modifier?",
                List.of("public", "private", "protected", "final"), 'D'));

        questionList.add(new Question("What is the size of an int in Java?",
                List.of("4 bytes", "2 bytes", "8 bytes", "Depends on OS"), 'A'));

        questionList.add(new Question("Which package contains Scanner class?",
                List.of("java.util", "java.io", "java.lang", "java.text"), 'A'));
        int score = 0;

        System.out.println("Welcome to the Java Console Quiz!");

        for (Question q : questionList) {
            q.display();
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = sc.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questionList.size());

        if (score == questionList.size()) {
            System.out.println("Excellent! You got all answers right.");
        } else if (score >= 3) {
            System.out.println("Good job! Keep practicing.");
        } else {
            System.out.println("Try again to improve your score.");
        }

        sc.close();
    }
}
