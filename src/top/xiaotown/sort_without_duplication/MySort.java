package top.xiaotown.sort_without_duplication;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public final class MySort {

    public static void sort(List<MapSqlParameterSource> list, String... keys) {
        int size = list.size();
        ListIterator lit = list.listIterator(size);
        Set<String> seen = new HashSet<>();
        while (lit.hasPrevious()) {
            MapSqlParameterSource ele = (MapSqlParameterSource) lit.previous();
            if (!seen.add(getKeys(ele, keys))) {
                lit.remove();
            }
        }
    }

    private static String getKeys(MapSqlParameterSource obj, String... keys) {
        StringBuffer sbf = new StringBuffer();
        for (String key : keys) {
            sbf.append(obj.getValue(key));
        }
        return sbf.toString();
    }
}
