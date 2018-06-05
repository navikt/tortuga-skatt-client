package no.nav.opptjening.skatt.api;

import no.nav.opptjening.skatt.exceptions.HttpException;
import no.nav.opptjening.skatt.schema.hendelsesliste.Feilmelding;

public class FeilmeldingTestCase {
    private final String feilkode;
    private final String feilmelding;
    private final String korrelasjonsid;
    private final int expectedHttpStatus;
    private final Class<? extends HttpException> expectedExceptionClass;
    private final String expectedMessage;

    public FeilmeldingTestCase(String feilkode, String feilmelding, String korrelasjonsid, int expectedHttpStatus, Class<? extends HttpException> expectedExceptionClass, String expectedMessage) {
        this.feilkode = feilkode;
        this.feilmelding = feilmelding;
        this.korrelasjonsid = korrelasjonsid;
        this.expectedHttpStatus = expectedHttpStatus;
        this.expectedExceptionClass = expectedExceptionClass;
        this.expectedMessage = expectedMessage;
    }

    public Feilmelding getFeilmelding() {
        return new Feilmelding(feilkode, feilmelding, korrelasjonsid);
    }

    public Class<? extends HttpException> getExpectedExceptionClass() {
        return expectedExceptionClass;
    }

    public int getExpectedHttpStatus() {
        return expectedHttpStatus;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }
}
