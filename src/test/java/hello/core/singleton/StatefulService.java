package hello.core.singleton;

public class StatefulService {
    /* 싱글톤의 단점 공유 필드를 만들면 안된다

    private  int price; // 상태를 유지하는 필드
    public void order(String name, int price) {
        System.out.println("name = "+ name + "price = " +  price);
        this.price = price;
    }
     */

    public int order(String name, int price) {
        System.out.println("name = "+ name + "price = " +  price);
        return price;
    }
}
