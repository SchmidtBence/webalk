package hu.me.iit.webapps.db;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import hu.me.iit.webapps.db.repository.PeopleModel;
import hu.me.iit.webapps.db.repository.PeopleRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void shouldNpMainPage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void shouldReturnPeoples() throws Exception {
        // GIVEN
        PeopleModel people=new PeopleModel(1L,12,"1");
        peopleRepository.save(people);
        // WHEN THEN
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"1\",\"age\":12}]"));

    }

    @Test
    public void shouldReturnPeoples1() throws Exception {
        // GIVEN
        PeopleModel people=new PeopleModel(1L,12,"1");
        peopleRepository.save(people);
        // WHEN THEN
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"2\",\"age\":22}]"));

    }
}
