package persestance.old;

import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserStore {
    private AtomicLong currentId = new AtomicLong();

    public AtomicLong getCurrentId(){
        return currentId;
    }

    private static UserStore instance;

    public static UserStore getInstance(){
        if(instance == null) {
            instance = new UserStore();
        }
        return instance;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setCars(List<User> users) {
        this.users = users;
    }

    private List<User> users = new ArrayList<>();

    public boolean adduser(User user){
        return this.users.add(user);
    }

    public boolean removeUser(User user){
        return users.remove(user);
    }



    public UserStore(){

    }
}
