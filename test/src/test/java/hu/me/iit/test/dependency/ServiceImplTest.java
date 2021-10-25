package hu.me.iit.test.dependency;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {
@Mock
Dependency dependency;

@InjectMocks ServiceImpl service;

    @Test
    void calculateTest() {
        //GIVEN

        //WHEN
        service.calculate();

        //THEN
        verify(dependency, times(1)).helpNoParameterNoReturnValue();
    }

    @Test
    void returnsTest() {
        //GIVEN
        final int FIVE=5;
        //WHEN
        int result=service.return5();

        //THEN
        assertEquals(FIVE, result);
    }

    @Test
    void dependencyReturnValueIsUsed() {
        //GIVEN
        final int FIVE=5;

        when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);
        //WHEN
        int result=service.callHelpAndUseReturnValue();

        //THEN
        assertEquals(FIVE, result);
        verify(dependency, times(1)).helpNoParameterReturnValue();
    }

    @Test
        // Is the service calls the dependency?
        // Is the parameter of dependency method appropriate?
    void callHelpAndPassParameter5Test() {
        // GIVEN
        final int FIVE = 5;

        // WHEN
        service.callHelpAndPassParameter5();

        // THEN
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
        assertEquals(FIVE,captor.getValue());
    }

    @Test
    void getImportantAbstractTest() {
        //GIVEN
        final String expected = "Try...";
        final String fromImportant = "<b>Try...</b>";
        final String sentence = "Trying the method with this sentence";
        when(dependency.Important(expected)).thenReturn(fromImportant);
        //WHEN
        String result = service.getImportantAbstract(sentence);
        //THEN
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(dependency, times(1)).Important(captor.capture());
        assertEquals(expected,captor.getValue());
        assertEquals(fromImportant, result);
    }
}