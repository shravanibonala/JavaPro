import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public QuizQuestion(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void start() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                System.out.println("Time's up!");
                nextQuestion();
            }
        }, 10000); // 10 seconds

        displayQuestion();
    }

    private void displayQuestion() {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        System.out.println(currentQuestion.getQuestion());
        List<String> options = currentQuestion.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (answer == currentQuestion.getCorrectAnswer()) {
            System.out.println("Correct answer!");
            score++;
        } else {
            System.out.println("Wrong answer!");
        }

        nextQuestion();
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
        } else {
            System.out.println("Quiz ended! Your score: " + score);
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", List.of("1. Paris", "2. Rome", "3. London", "4. Berlin"), 1));
        questions.add(new QuizQuestion("Which programming language is used to develop Android apps?", List.of("1. Java", "2. Python", "3. C++", "4. JavaScript"), 1));
        questions.add(new QuizQuestion("Who is the CEO of Tesla?", List.of("1. Jeff Bezos", "2. Elon Musk", "3. Mark Zuckerberg", "4. Tim Cook"), 2));

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
