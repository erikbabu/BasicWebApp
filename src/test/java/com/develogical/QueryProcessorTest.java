package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsOurTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your team name"), containsString("The LADS"));
    }

    @Test
    public void knowsAboutErik() throws Exception {
        assertThat(queryProcessor.process("Erik"), containsString("deploy"));
    }

    @Test
    public void addingNumebers() throws Exception {
        assertThat(queryProcessor.process("what is 4 plus 5"), containsString("9"));
    }

    @Test
    public void multiplyingNumebers() throws Exception {
        assertThat(queryProcessor.process("what is 4 multiplied by 5"), containsString("20"));
    }

    @Test
    public void minusgNumebers() throws Exception {
        assertThat(queryProcessor.process("what is 4 minus 5"), containsString("-1"));
    }


    @Test
    public void knowsTheLargestNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 10, 20"), containsString("20"));
    }

    @Test
    public void wordAssociations() throws Exception {
        assertThat(queryProcessor.process("Which city is the Eiffel tower in?"), containsString("Paris"));
        assertThat(queryProcessor.process("What colour is a banana?"), containsString("yellow"));
        assertThat(queryProcessor.process("James bond"), containsString("Sean Connery"));
        assertThat(queryProcessor.process("theresa may"), containsString("2016"));
    }

    public void knowsTheSquareAndCube() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 7, 64"), containsString("64"));
    }

    @Test
    public void knowsPrimeNumbers() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers are primes: 7, 23, 4"), containsString("7, 23"));
    }

    @Test
    public void knowsFibonacciNumbers() throws Exception {
        assertThat(queryProcessor.process("what is the 5th number in the Fibonacci sequence"), containsString("5"));
    }

    @Test
    public void testSquareAndCube() throws Exception {
        int test = 64;
        assert(queryProcessor.isSquareAndCube(test));
    }
}
