package servis2;

import com.havelsan.servis2.UserRepositoryImpl;
import com.havelsan.servis2.UserServisImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class UserServisTest {

  private UserServisImpl userServiceImpl;
  private UserRepositoryImpl userRepositoryMock;

  @Before
  public void setUp() throws Exception {
    userRepositoryMock = Mockito.mock(UserRepositoryImpl.class);
    userServiceImpl = new UserServisImpl(userRepositoryMock);
  }

  @Test
  public void test_get_usersd() {

  }
}
