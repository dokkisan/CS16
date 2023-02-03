package CS10;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Process processA = new Process(new PCB("A", PCB.State.READY, "0", "0", "3"));
        Process processB = new Process(new PCB("B", PCB.State.READY, "0", "0", "5"));
        Process processC = new Process(new PCB("C", PCB.State.READY, "0", "0", "7"));

        Queue<Process> readyQueue = new LinkedList<>();
        readyQueue.add(processA);
        readyQueue.add(processB);
        readyQueue.add(processC);

        Output output = new Output();
        output.printContext(processA.getPcb().getName(), processA.getPcb().getState().toString(), processA.getPcb().getRunningTime(), processA.getPcb().getMaxOperatingTime());
        output.printContext(processB.getPcb().getName(), processB.getPcb().getState().toString(), processB.getPcb().getRunningTime(), processB.getPcb().getMaxOperatingTime());
        output.printContext(processC.getPcb().getName(), processC.getPcb().getState().toString(), processC.getPcb().getRunningTime(), processC.getPcb().getMaxOperatingTime());

        Queue<Process> waitQueue = new LinkedList<>();
        waitQueue.add(processA);
        waitQueue.add(processB);
        waitQueue.add(processC);

        waitQueue.remove(processA);
        waitQueue.remove(processB);
        waitQueue.remove(processC);
    }
}
