package member.core.singleton;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonService {

        private static final SingletonService instance = new SingletonService();
//    private static SingletonService instance = null;

//    public static synchronized SingletonService getInstance() {
//        instance = new SingletonService();
//        return instance;
//    }
    public static synchronized SingletonService getInstance() {
        return instance;
    }
    
    private SingletonService() {
    }
    
}
