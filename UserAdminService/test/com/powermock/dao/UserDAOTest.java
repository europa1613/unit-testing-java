package com.powermock.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.powermock.dto.User;
import com.powermock.util.IdGenerator;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class UserDAOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createShouldReturnAUserId() {
		UserDAO dao = new UserDAO();

		PowerMockito.mockStatic(IdGenerator.class);
		when(IdGenerator.generateId()).thenReturn(1);

		int result = dao.create(new User());

		assertEquals(1, result);
		PowerMockito.verifyStatic();
	}

}
