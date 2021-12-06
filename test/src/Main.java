import com.ren.dao.IGoodsDao;
import com.ren.dao.impl.GoodsDao;
import com.ren.entity.Goods;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        IGoodsDao dao = new GoodsDao();
       List<Goods> Listgoods=dao.select(3249);
       for(Goods it:Listgoods){
           System.out.println(it);
       }
    }
}
