package com.bumptech.glide.load.resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SimpleResourceTest {
    private Anything object;
    private SimpleResource resource;

    @Before
    public void setUp() {
        object = new Anything();
        resource = new SimpleResource(object);
    }

    @Test
    public void testReturnsGivenObject() {
        assertEquals(object, resource.get());
    }

    @Test
    public void testReturnsGivenObjectMultipleTimes() {
        assertEquals(object, resource.get());
        assertEquals(object, resource.get());
        assertEquals(object, resource.get());
    }

    @Test(expected = NullPointerException.class)
    public void testThrowsIfGivenNullData() {
        new SimpleResource<Object>(null);
    }

    private static class Anything { }
}
