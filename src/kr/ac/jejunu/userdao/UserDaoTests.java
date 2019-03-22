package kr.ac.jejunu.userdao;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class UserDaoTests {
    @Test
    public void testGet() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "강민규";
        String password = "1234";
        UserDao userDao = new UserDao();
        User user = userDao.get(id);
        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void testAdd() throws SQLException, ClassNotFoundException {
        String name = "알렉산드로";
        String password = "1111";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        Long id = userDao.add(user);
        User resultuser = userDao.get(id);
        assertThat(resultuser.getId(), is(id));
        assertThat(resultuser.getName(), is(name));
        assertThat(resultuser.getPassword(), is(password));
    }

}
