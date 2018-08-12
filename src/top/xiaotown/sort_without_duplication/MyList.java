package top.xiaotown.sort_without_duplication;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyList<E> extends ArrayList<E> {


    public Stream<E> myStream(int size) {
        return StreamSupport.stream(mySpliterator(size), false);
    }

    public Spliterator<E> mySpliterator(int size) {
        return Spliterators.spliterator(this, size);
    }
}
