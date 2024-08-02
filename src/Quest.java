import java.util.ArrayList;
import java.util.HashMap;

public class Quest {
    public void run() {
        ArrayList<HashMap<String, String>> questions = new ArrayList<>();

        addQuestion(questions, "1. Python에서 변수를 선언하는 방법은? (점수: 10점)", "1) var name 2) name = value 3) set name 4) name == value", "2", 10);
        addQuestion(questions, "2. Python에서 리스트(List)의 특징은 무엇인가요? (점수: 15점)", "1) 순서가 있고 변경 가능하다, 2) 중복된 값을 가질 수 없다, 3) 원소를 추가하거나 삭제할 수 없다, 4) 정렬된 상태로 유지된다", "1", 15);
        addQuestion(questions, "3. Python에서 조건문을 작성하는 방법은? (점수: 10점)", "1) if-else, 2) for-in, 3) while, 4) def", "1", 10);
        addQuestion(questions, "4. Python에서 함수를 정의하는 방법은? (점수: 5점)", "1) class, 2) def, 3) import, 4) return", "2", 5);

        ArrayList<String> userResponses = new ArrayList<>();
        userResponses.add("4");
        userResponses.add("2");
        userResponses.add("3");
        userResponses.add("2");

        int totalScore = 0;
        int userScore = 0;

        for (int i = 0; i < questions.size(); i++) {
            HashMap<String, String> question = questions.get(i);
            int score = Integer.parseInt(question.get("score"));
            totalScore += score;
            if (userResponses.get(i).equals(question.get("correct"))) {
                userScore += score;
            }
        }

        // 결과 출력
        System.out.println("—----- 결과 —-------------");
        for (int i = 0; i < userResponses.size(); i++) {
            System.out.println((i + 1) + "번 응답: " + userResponses.get(i));
        }
        System.out.println("당신의 총 점수: " + userScore + "점");

        // 학점 계산
        char grade = calculateGrade(userScore);
        System.out.println("학점은 " + grade + " 입니다.");
    }

    private void addQuestion(ArrayList<HashMap<String, String>> questions, String questionText, String choices, String correctAnswer, int score) {
        HashMap<String, String> question = new HashMap<>();
        question.put("question", questionText);
        question.put("choices", choices);
        question.put("correct", correctAnswer);
        question.put("score", String.valueOf(score));
        questions.add(question);
    }

    private char calculateGrade(int score) {
        if (score >= 90) return 'A';
        if (score >= 80) return 'B';
        if (score >= 70) return 'C';
        if (score >= 60) return 'D';
        return 'F';
    }


}
