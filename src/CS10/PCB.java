package CS10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


// OS가 프로세스를 관리하기 위한 커널 내 자료구조
// process context를 구성하는 중요한 요소
public class PCB {
    private String name;
    private State state;
    private String waitingTime;
    private String runningTime;
    private String maxOperatingTime;
    private String schedulingInfo;

    public enum State {
        READY("ready"), // CPU를 기다리는 상태
        RUNNING("running"), // CPU를 잡고 instruction을 수행중인 상태
        WAITING("waiting"), // CPU를 줘도 instruction을 수행할 수 없는 생테
        TERMINATED("terminated"); // 수행(execution)이 끝난 상태
        State(String state) {
        }
    }

    public PCB(String name, State state, String waitingTime, String runningTime, String maxOperatingTime) {
//        List<Object> context = new ArrayList<>(this.maxOperatingTime = maxOperatingTime);
        this.name = name;
        this.state = state;
        this.waitingTime = waitingTime;
        this.runningTime = runningTime;
        this.maxOperatingTime = maxOperatingTime;
    }

    // Output에 context 전달하는 메서드 필요

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public String getWaitingTime() {
        return waitingTime;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public String getMaxOperatingTime() {
        return maxOperatingTime;
    }

    public String getSchedulingInfo() {
        return schedulingInfo;
    }
}
