package cs06.view;

public class OutputView {

    public void printExecuteInfo() {
        System.out.println("(프로그램 실행)");
    }

    public void printBoardInitInfo() {
        System.out.println("체스 보드를 초기화했습니다.");
    }

    public void printInputCommandInfo() {
        System.out.println("명령을 입력하세요.");
        System.out.print(">");
    }

    public void printTurnInfo() {
        System.out.println("체스말의 차례입니다.");
    }
}
