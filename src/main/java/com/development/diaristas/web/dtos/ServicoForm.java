package com.development.diaristas.web.dtos;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.development.diaristas.core.enums.Icone;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// @NoArgsConstructor
// @AllArgsConstructor
@Data
public class ServicoForm {
    
    
    @NotNull
    @Size(min = 3, max = 50)
    private String nome;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorMinimo;

    @NotNull
    @PositiveOrZero
    private Integer qtdHoras;

    @NotNull
    @PositiveOrZero
    @Max(value = 100)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal porcentagemComissao;
    
    @NotNull
    @PositiveOrZero
    private BigDecimal horasQuarto;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuarto;
    
    @NotNull
    @PositiveOrZero
    private Integer horasSala;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorSala;
    
    @NotNull
    @PositiveOrZero
    private Integer horasBanheiro;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorBanheiro;
    
    @NotNull
    @PositiveOrZero
    private Integer horasCozinha;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorCozinha;
    
    @NotNull
    @PositiveOrZero
    private Integer horasQuintal;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorQuintal;
    
    @NotNull
    @PositiveOrZero
    private Integer horasOutros;
    
    @NotNull
    @PositiveOrZero
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorOutros;

    @NotNull
    private Icone icone;
    
    @NotNull
    @Positive
    private Integer posicao;

}
