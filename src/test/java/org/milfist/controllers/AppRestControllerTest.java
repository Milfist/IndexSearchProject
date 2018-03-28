package org.milfist.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
@ContextConfiguration(classes = { AppConfig.class })
public class AppRestControllerTest {

	@Mock
	private TwitterService serviceMock;

	@InjectMocks
	private AppRestController appRestControllerMock;

	private MockMvc mockMvc;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(appRestControllerMock).build();
	}

	@Test
	public void shouldBeOKWhenCallToExampleANDAFilterIsRecived() throws Exception {

		when(serviceMock.getTwittsExample(anyString())).thenReturn(this.getStream());
		this.mockMvc.perform(get("/searchExample"))
													.andExpect(status().isOk())
													.andExpect(jsonPath("$[0]", is("A")))
													.andExpect(jsonPath("$[1]", is("B")))
													.andExpect(jsonPath("$[2]", is("C")))
													.andReturn();

	}

	@Test
	public void shouldBeThrowsExceptionWhenCallToExampleANDFilterISNull() throws Exception {

		expectedEx.expect(Exception.class );
		expectedEx.expectCause(org.hamcrest.Matchers.any(NullPointerException.class));
			
		this.mockMvc.perform(get("/searchExample"));
	}
	
	@Test
	public void shouldBeOKWhenCallToSearchANDAFilterIsRecived() throws Exception {

		when(serviceMock.getTwitts(anyString())).thenReturn(this.getResultList());
		this.mockMvc.perform(get("/search"))
											.andExpect(status().isOk())
											.andExpect(jsonPath("$[0]", is("A")))
											.andExpect(jsonPath("$[1]", is("B")))
											.andExpect(jsonPath("$[2]", is("C")))
											.andReturn();
	}

	@Test
	public void shouldBeThrowExceptionWhenCallSarchANDFilterISNull() throws Exception {

		expectedEx.expect(Exception.class );
		expectedEx.expectCause(org.hamcrest.Matchers.any(NullPointerException.class));
			
		this.mockMvc.perform(get("/search"));
	}

	private Stream<String> getStream() {
		return Stream.of("A", "B", "C");
	}
	
	private List<String> getResultList() {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");	
		return list;
	}

}
