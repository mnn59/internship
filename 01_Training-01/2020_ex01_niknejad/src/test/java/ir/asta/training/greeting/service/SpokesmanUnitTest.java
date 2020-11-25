package ir.asta.training.greeting.service;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SpokesmanUnitTest {
    private SpokesmanImpl spokesman = new SpokesmanImpl();

    //hello
    @Test
    public void testGreetIsCalledIfUserIsNullAndHonorificIsNull() {
        String response = spokesman.greet(null, null);
        assertEquals("Hello dear User!", response);
    }


    //hello?user=
    @Test
    public void testGreetIsCalledIfUserIsEmptyAndHonorificIsNull() {
        String response = spokesman.greet("", null);
        assertEquals("Hello dear User!", response);
    }

    //hello?user=[space(s)]
    @Test
    public void testGreetIsCalledIfUserHasSpaceValueAndHonorificIsNull() {
        String response = spokesman.greet(" ", null);
        assertEquals("Hello dear User!", response);
    }

    //hello?user=Ahmad
    @Test
    public void testGreetIsCalledIfUserHasValidValueAndHonorificIsNull() {
        String response = spokesman.greet("Ahmad", null);
        assertEquals("Hello dear Ahmad!", response);
    }

    //hello?honorific=
    @Test
    public void testGreetIsCalledIfUserIsNullAndHonorificIsEmpty() {
        String response = spokesman.greet(null, "");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=&user=
    @Test
    public void testGreetIsCalledIfUserIsEmptyAndHonorificIsEmpty() {
        String response = spokesman.greet("", "");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=&user=[space(s)]
    @Test
    public void testGreetIsCalledIfUserHasSpaceValueAndHonorificIsEmpty() {
        String response = spokesman.greet(" ", "");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=&user=Ahmad
    @Test
    public void testGreetIsCalledIfUserHasValidValueAndHonorificIsEmpty() {
        String response = spokesman.greet("Ahmad", "");
        assertEquals("Hello dear Ahmad!", response);
    }

    //hello?honorific=[space(s)]
    @Test
    public void testGreetIsCalledIfUserIsNullAndHonorificHasSpaceValue() {
        String response = spokesman.greet(null, " ");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=[space(s)]&user=
    @Test
    public void testGreetIsCalledIfUserIsEmptyAndHonorificHasSpaceValue() {
        String response = spokesman.greet("", " ");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=[space(s)]&user=[space(s)]
    @Test
    public void testGreetIsCalledIfUserHasSpaceValueAndHonorificHasSpaceValue() {
        String response = spokesman.greet(" ", " ");
        assertEquals("Hello dear User!", response);
    }

    //hello?honorific=[space(s)]&user=Ahmad
    @Test
    public void testGreetIsCalledIfUserHasValidValueAndHonorificHasSpaceValue() {
        String response = spokesman.greet("Ahmad", " ");
        assertEquals("Hello dear Ahmad!", response);
    }


    //hello?honorific=Mr
    @Test
    public void testGreetIsCalledIfUserIsNullAndHonorificHasValidValue() {
        String response = spokesman.greet(null, "Mr");
        assertEquals("Hello Mr User!", response);
    }

    //hello?honorific=Mr&user=
    @Test
    public void testGreetIsCalledIfUserIsEmptyAndHonorificHasValidValue() {
        String response = spokesman.greet("", "Mr");
        assertEquals("Hello Mr User!", response);
    }

    //hello?honorific=Mr&user=[space(s)]
    @Test
    public void testGreetIsCalledIfUserHasSpaceValueAndHonorificHasValidValue() {
        String response = spokesman.greet(" ", "Mr");
        assertEquals("Hello Mr User!", response);
    }

    //hello?honorific=Mr&user=Ahmad
    @Test
    public void testGreetIsCalledIfUserHasValidValueAndHonorificHasValidValue() {
        String response = spokesman.greet("Ahmad", "Mr");
        assertEquals("Hello Mr Ahmad!", response);
    }

}
