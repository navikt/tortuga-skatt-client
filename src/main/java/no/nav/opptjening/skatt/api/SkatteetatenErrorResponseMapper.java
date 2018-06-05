package no.nav.opptjening.skatt.api;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.opptjening.skatt.api.exceptions.ResponseUnmappableException;
import no.nav.opptjening.skatt.schema.hendelsesliste.Feilmelding;
import retrofit2.Response;

import java.io.IOException;

class SkatteetatenErrorResponseMapper {
    private final ObjectMapper mapper;

    public SkatteetatenErrorResponseMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <S> Feilmelding mapErrorResponseToFeilmelding(Response<S> response) {
        try {
            return mapper.readValue(response.errorBody().string(), Feilmelding.class);
        } catch (JsonMappingException e) {
            throw new ResponseUnmappableException("Kan ikke mappe respons til Feilmelding på grunn av skjemafeil", e);
        } catch (IOException e) {
            throw new ResponseUnmappableException("Kan ikke mappe respons til Feilmelding", e);
        }
    }
}
