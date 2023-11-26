package hello.core.singleton;

public class SingletonService {
    //객체 1개만 생성해둔다
    private  static final SingletonService instance = new SingletonService();
    //인스턴스가 필요하면 이 매서드를 통해서만 접근허용한다
    public  static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 선언해서 new를 못 쓰게 만든다
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
