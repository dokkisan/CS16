package CS09;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class SquadSet {
    private List<Integer> source;

    public SquadSet() {

    }

    public SquadSet(List<Integer> source) {
        this.source = source;
    }

    // 합집합
    public static SquadSet sum(SquadSet setA, SquadSet setB) {
        List<Integer> sourceA = new ArrayList<>(setA.source);
        List<Integer> sourceB = new ArrayList<>(setB.source);

        List<Integer> sourceC = Stream.concat(sourceA.stream(), sourceB.stream())
                                      .distinct().collect(Collectors.toList());

        return new SquadSet(sourceC);
    }

    public static SquadSet complement(SquadSet other) {


        return new SquadSet();
    }

    public static void main(String[] args) {
        SquadSet setA = new SquadSet(List.of(1,2,3));
        SquadSet setB = new SquadSet(List.of(1,3));

        SquadSet sum = sum(setA, setB);     //  합집합
    }
}