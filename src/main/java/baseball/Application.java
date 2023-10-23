package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

//    public String setRandomDistinctNumbers() {
//        List<String> computer = new ArrayList<>();
//        while (computer.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1, 9);
//            if (!computer.contains(randomNumber)) {
//                computer.add(String.valueOf(randomNumber));
//            }
//        } return computer;
//    }

    public String startGame() {
        return "숫자 야구 게임을 시작합니다.";
    }
    //TODO : 리팩토링 메소드 명 변경
    //TODO : convertToList 메소드 만들기
    public int compareDigitsNumbers(String answer, String input) {
        int strikeCnt = 0;

        List<Character> answerList = new ArrayList<>();
        List<Character> inputList = new ArrayList<>();
        for(int i = 0; i<3; i++){
            answerList.add(answer.charAt(i));
            inputList.add(input.charAt(i));
        }

        for(int i = 0; i<3; i++) {
            if (answerList.get(i).equals(inputList.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }
    public int countCommonNumbers(String answer, String input) {
        int ballCnt = 0;
        List<Character> answerList = new ArrayList<>();
        List<Character> inputList = new ArrayList<>();
        for(int i = 0; i<3; i++){
            answerList.add(answer.charAt(i));
            inputList.add(input.charAt(i));
        }

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++) {
                if(answerList.get(i).equals(inputList.get(j))) {
                    ballCnt++;
                }
            }
        }

        return ballCnt;
    }

    public String showBaseballOutcome(String answer, String input) {
        int strikeCnt = compareDigitsNumbers(answer, input);
        int ballCnt = countCommonNumbers(answer, input);

        if (strikeCnt == 0) {
            if(ballCnt == 0){
                return "낫싱";
            }
            return ballCnt + "볼";
        }
        ballCnt -= strikeCnt;
        if (ballCnt == 0) {
            return strikeCnt + "스트라이크";
        } else {
            return ballCnt + "볼 " + strikeCnt + "스트라이크";
        }
    }

    public void confirmGameEnd(String choice, String answer, String input) {

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        switch (choice){
            case "1" ->{compareDigitsNumbers(answer,input); }
            case "2" ->{break;}
            default -> {checkExitChoiceValidation();}
        }
    }
    public void checkInputValidation(String input) {
        if (input == null || input.isEmpty() || !input.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }
        char[] digits = input.toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    public void checkExitChoiceValidation() {
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {

    }
}
