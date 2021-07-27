package com.javastream.spliterator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpliteratorsTest {

    @Test
    @DisplayName("General split test")
    void defaultTest() {
        String str = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";

        Spliterators spliterator = new Spliterators(str);

        String s = spliterator
                .split(",")
                .choice(1)
                .split(" ")
                .choice(0)
                .trim()
                .build();

        assertNotNull(s);
        assertTrue(s.length() > 0);
        assertEquals(s, "Wonders");
    }


    @Test
    @DisplayName("Wrong Regex And True Choice")
    void wrongRegexAndTrueChoiceTest() {
        String str = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";

        Spliterators spliterator = new Spliterators(str);

        String s = spliterator.split("r1")
                .choice(0)
                .build();

        assertNotNull(s);
        assertTrue(s.length() > 0);
        assertEquals(s, str);
    }

    @Test
    @DisplayName("Wrong Regex Return Given String")
    void wrongRegexAndWrongChoiceTest() {
        String str = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";

        Spliterators spliterator = new Spliterators(str);

        String s = spliterator.split("r1")
                .choice(100)
                .build();

        assertNotNull(s);
        assertTrue(s.length() == 0);
        assertEquals(s, "");
    }

    @Test
    @DisplayName("Build after split without using choice method")
    void buildTest() {
        String str = "Natural Wonders,Wonders of the World,Mount Everest,Saturn,2,UNESCO";

        Spliterators spliterator = new Spliterators(str);

        String s = spliterator.split(",")
                .build();

        assertNotNull(s);
        assertTrue(s.length() > 0);
        assertEquals(s, "Natural Wonders");
    }

}