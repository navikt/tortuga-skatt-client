package no.nav.opptjening.skatt.dto;

public class InntektHendelseDto {

    public String endret;

    public String personindentfikator;

    public String inntektsaar;

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        return sb.append("pid: ")
                .append(personindentfikator)
                .append(", inntektsAar: ")
                .append(inntektsaar)
                .append(", endret: ")
                .append(endret)
                .append("]")
                .toString();
    }
}
