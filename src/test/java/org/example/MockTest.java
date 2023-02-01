package org.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MockTest {

    @Inject
    MyBean myBean;

    @Test
    void mockingWorks() {
        MyBean myBeanMock = Mockito.mock(MyBean.class);
        // OptaPlanner detects the mock is not the class nor subclass of the PlanningSolution.
        when(myBeanMock.getMyClass()).thenReturn(mock(MyClass.class));
        QuarkusMock.installMockForInstance(myBeanMock, myBean);
        assertThat(myBean.getMyClass().getClass().getName()).contains("$MockitoMock");
    }
}
