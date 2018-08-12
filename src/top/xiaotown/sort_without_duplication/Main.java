package top.xiaotown.sort_without_duplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        MyList<Entity> list = new MyList<>();
        list.add(new Entity("01","wangyu","1"));
        list.add(new Entity("02","wangyu","1"));
        list.add(new Entity("03","wangyu","1"));
        list.add(new Entity("01","wangyu2","2"));
        list.add(new Entity("04","wangyu4","4"));
        list.add(new Entity("05","wangyu5","5"));
        list.add(new Entity("02","wangyu6","6"));



//        MyList<Entity> result = sort(list);
        list.forEach(System.out::println);
    }

    private static MyList<Entity> sort(MyList<Entity> list)
    {
        int size = list.size();
        Collections.reverse(list);
        Stream.iterate(size,e->e-1).limit(size);
        return list.myStream(size).filter(distinctByKey(Entity::getId)).collect(Collectors.toCollection(MyList::new));

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
