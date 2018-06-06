package no.nav.opptjening.skatt.client.api;

import junit.framework.TestCase;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import org.junit.Assert;

import java.util.List;

public abstract class AbstractFeilmeldingExceptionMapperTest {

    public void runTests(FeilmeldingExceptionMapper exceptionMapper, List<FeilmeldingTestCase> testCases) throws Exception {
        for (FeilmeldingTestCase testCase : testCases) {
            HttpException exception = exceptionMapper.mapFeilmeldingToHttpException(testCase.getFeilmelding());

            if (exception == null) {
                TestCase.fail("Did not expect mapFeilmeldingToHttpException to return null for " + testCase.getFeilmelding());
            }

            Assert.assertEquals("Expecation failed for feilmelding=" + testCase.getFeilmelding().toString(), testCase.getExpectedExceptionClass(), exception.getClass());
            Assert.assertEquals("Expecation failed for feilmelding=" + testCase.getFeilmelding().toString(), testCase.getExpectedHttpStatus(), exception.getHttpStatus());
            Assert.assertEquals("Expecation failed for feilmelding=" + testCase.getFeilmelding().toString(), testCase.getExpectedMessage(), exception.getMessage());
        }
    }
}
