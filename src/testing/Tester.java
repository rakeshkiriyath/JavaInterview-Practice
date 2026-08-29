package testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

    public static void main(String ... args) {

        KeyBean obj = new KeyBean(1,"Kraken");
        KeyBean obj1 = new KeyBean(2,"CoinBase");
        KeyBean obj2 = new KeyBean(1,"Kraken");
        KeyBean obj3 = new KeyBean(3,"GCP");

        List<KeyBean> keyBeanList = Arrays.asList(obj,obj1,obj2,obj3);

        List<KeyBean> newBeanList = new ArrayList<>();
        newBeanList.add(keyBeanList.getFirst());

        for(KeyBean keyBean : keyBeanList) {
          
        }

    }

}
