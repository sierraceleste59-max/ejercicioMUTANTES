package com.example.appMutante.DTO;
import com.example.appMutante.Validator.ValidDna;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DnaRequest {
    @NotNull
    @ValidDna // Validación personalizada
    @Schema(example = " [\n" +
            "    \"AAAAGA\",\n" +
            "    \"CAGTGC\",\n" +
            "    \"TTATGT\",\n" +
            "    \"AGAAGG\",\n" +
            "    \"CACCTA\",\n" +
            "    \"TCACTG\"\n" +
            "  ]")
    private String[] dna;
}