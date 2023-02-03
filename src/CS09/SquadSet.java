package CS09;

import java.util.*;
import java.util.stream.*;

public class SquadSet {
    private final List<Integer> source;


    public SquadSet(List<Integer> source) {
        this.source = source;
    }

    public final SquadSet sum(SquadSet other) {
        return new SquadSet(Stream.concat(source.stream(), other.getSource().stream())
                                  .distinct().collect(Collectors.toList()));
    }

//    public final SquadSet complement(SquadSet other) {
//
//    }

    public final SquadSet intersect(SquadSet other) {
        return new SquadSet(source.stream().filter(other.getSource()::contains)
                                  .collect(Collectors.toList()));
    }

    public final List<Integer> resultAll() {
        return Collections.unmodifiableList(source);
    }

    public List<Integer> getSource() {
        return source;
    }

    public static void main(String[] args) {
        SquadSet setA = new SquadSet(List.of(1,2,3));
        SquadSet setB = new SquadSet(List.of(1,3));

        // 합집합
        SquadSet sum = setA.sum(setB);
        System.out.println("합집합sum = " + Arrays.toString(sum.resultAll().toArray()));
        // 차집합
//        SquadSet complement = setA.complement(setB);
//        System.out.println("차집합complement = " + Arrays.toString(complement.resultAll().toArray()));
        // 교집합
        SquadSet intersect = setA.intersect(setB);
        System.out.println("교집합intersect = " + Arrays.toString(intersect.resultAll().toArray()));
    }
}