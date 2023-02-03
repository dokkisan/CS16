package CS10;

public class Output {

    public void printContext(String name, String state, String runningTime, String maxOperatingTime) {
//        System.out.printf("%S, %d, %d", state, waitingTime, runningTime);
        System.out.println(name + "(" + state + "), " + runningTime + " / " + maxOperatingTime +"sec");
    }
}
