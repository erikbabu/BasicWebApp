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
    public void knowsTheLargestNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 10, 20"), containsString("20"));
    }
}
