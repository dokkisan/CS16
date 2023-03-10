package CS09;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquadSet {
    private final List<Integer> source;

    public SquadSet(List<Integer> source) {
        this.source = source;
    }


    public final SquadSet sum(SquadSet other) {
        return new SquadSet(Stream.concat(source.stream(), other.getSource().stream())
                .distinct().collect(Collectors.toList()));
    }

    public final SquadSet complement(SquadSet other) {
        return new SquadSet(source.stream().filter(source -> !other.getSource().contains(source))
                .collect(Collectors.toList()));
    }

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
        SquadSet setA = new SquadSet(List.of(1, 2, 3));
        SquadSet setB = new SquadSet(List.of(1, 3));

        System.out.println("A 집합 = " + Arrays.toString(setA.resultAll().toArray()));
        System.out.println("B 집합 = " + Arrays.toString(setB.resultAll().toArray()));

        SquadSet sum = setA.sum(setB);
        System.out.println("합집합sum = " + Arrays.toString(sum.resultAll().toArray()));

        SquadSet complement = setA.complement(setB);
        System.out.println("차집합complement = " + Arrays.toString(complement.resultAll().toArray()));

        SquadSet intersect = setA.intersect(setB);
        System.out.println("교집합intersect = " + Arrays.toString(intersect.resultAll().toArray()));
    }
}