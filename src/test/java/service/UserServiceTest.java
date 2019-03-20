package service;


import com.havelsan.service.User;
import com.havelsan.service.UserRepository;
import com.havelsan.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UserServiceTest {

    private UserServiceImpl userService;

    private UserRepository userRepositoryMock;

  @Before
  public void setUp() throws Exception {
      userRepositoryMock = Mockito.mock(UserRepository.class);

      userService = new UserServiceImpl(userRepositoryMock);
  }

    @Test
    public void test_get_users(){

      List<User> givenUsers = new ArrayList<User>();
      givenUsers.add(new User("okan","akgoz"));
      givenUsers.add(new User("testUser","testSurname"));

      Mockito.when(userRepositoryMock.getUsers()).thenReturn(givenUsers);


        List<User> result= userService.getUsers();
        assertNotNull(result);
        assertEquals(2,result.size());
    }

}
