package CS10;

public class Process {
    private PCB pcb;

    public Process(PCB pcb) {
        this.pcb = pcb;
    }

    public PCB getPcb() {
        return pcb;
    }
}
