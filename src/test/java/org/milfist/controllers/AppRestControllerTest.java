package org.milfist.controllers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.milfist.services.AppConfig;
import org.milfist.services.TwitterService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppRestControllerTest {

	@Mock
	private TwitterService serviceMock;

	@InjectMocks
	private AppRestController appRestControllerMock;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(appRestControllerMock).build();
	}

	@Test
	public void dataIsExpectedWhenAFilterIsRecived() {

		try {
			when(serviceMock.getTwitts(anyString())).thenReturn(this.stream());
			this.mockMvc.perform(get("/search?filter='madrid'")).andExpect(status().isOk());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
//		try {
//			when(serviceMock.getTwitts("")).thenReturn(this.stream());
//		} catch (TwitterException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	private Stream<String> stream() {
		
		
		
		return Stream.of("A", "B", "C");
	}

}

// @RequestMapping(value = "/search", method = RequestMethod.GET, produces =
// "application/json")
// public Object[] listar(String filter) throws TwitterException {
// return service.getTwitts(filter).toArray();
// }
//
// @RequestMapping(value = "/search2", method = RequestMethod.GET, produces =
// "application/json")
// public List<?> listar2(String filter) throws TwitterException {
// return service.getTwitts2(filter);
// }
