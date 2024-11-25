package br.com.github.davimc.ItSupport.unitTest;

import br.com.github.davimc.ItSupport.entities.User;
import br.com.github.davimc.ItSupport.repositories.RoleRepository;
import br.com.github.davimc.ItSupport.repositories.UserRepository;
import br.com.github.davimc.ItSupport.services.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Mock
    private UserService service;

    @InjectMocks
    private User userSaved;
    @InjectMocks
    private User userNotSavedYet;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }
    /*

    @BeforeEach
    public void setup() {
        userSaved = new User("John Due", "john@due.com", "12345", "Trabalha para uma empresa de engenaria",
                LocalDate.of(1890, 2,17), "982.206.830-15", null,null);
        mockSave(userSaved);
        userNotSavedYet = new User("Due John", "due@john.com", "12345", "Desconhecido",
                LocalDate.of(1890, 2,17), "277.871.340-97", null,null);
    }
    private void mockSave(User userSaved) {
        when(service.save(any(User.class))).thenReturn(userSaved);
    }*/
    @Test
    public void createdAtShouldReturnLocalDateTimeNowWhenObjectIsCreated() {
        /*System.out.println(userSaved.getId() + " " + userSaved.getName());
        Assertions.assertNotNull(userSaved.getId());*/
        System.out.println("Teste do teste");
    }
}
