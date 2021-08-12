package member.provider.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合分割工具类
 */
public class ListUtils {

    /**
     *
     * @param list
     *            目标集合列表
     * @param pageSize
     *            定义每条线程处理的数据量
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        if (pageSize == 0) {
            pageSize = 1;
        }
        int listSize = list.size();

        int page = (listSize + (pageSize - 1)) / pageSize;

        List<List<T>> listArray = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == (j + 1) * pageSize) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }

}
