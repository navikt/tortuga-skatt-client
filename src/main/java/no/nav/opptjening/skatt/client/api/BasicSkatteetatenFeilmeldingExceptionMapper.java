package no.nav.opptjening.skatt.client.api;

import no.nav.opptjening.skatt.client.Feilmelding;
import no.nav.opptjening.skatt.client.exceptions.ForbiddenException;
import no.nav.opptjening.skatt.client.exceptions.HttpException;
import no.nav.opptjening.skatt.client.exceptions.InternalServerErrorException;
import no.nav.opptjening.skatt.client.exceptions.NotFoundException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BasicSkatteetatenFeilmeldingExceptionMapper implements FeilmeldingExceptionMapper {
    @Nullable
    public HttpException mapFeilmeldingToHttpException(@NotNull Feilmelding feilmelding) {
        switch (feilmelding.getKode()) {
            case "DAS-001":
                return new InternalServerErrorException("Det var en uventet feil på tjenesten. Vennligst ta kontakt med brukerstøtte, med applikasjon og korrelasjonsid fra denne meldingen!");
            case "DAS-002":
                return new NotFoundException("Den forespurte URLen svarer ikke til et gyldig endepunkt");
            case "DAS-003":
                return new InternalServerErrorException("Den forespurte informasjonen er for øyeblikket utilgjengelig, vennligst prøv igjen senere! Dersom problemet vedvarer, ta kontakt med brukerstøtte!");
            case "DAS-004":
            case "DAS-005":
            case "DAS-006":
            case "DAS-007":
                return new InternalServerErrorException("Det skjedde en feil i forbindelse med intern autentisering i Skatteetaten");
            case "DAS-008":
                return new ForbiddenException("Du er ikke autorisert for tilgang til den forespurte ressursen.");
        }

        return null;
    }
}
