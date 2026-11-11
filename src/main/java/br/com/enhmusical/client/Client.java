package br.com.enhmusical;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "couplesName", nullable = false, length = 150)
    private String couplesName;

    @NotBlank
    @Column(length = 11)
    private String phone;

    @NotNull
    @Column(name = "dateEvent", nullable = false)
    private LocalDate dateEvent;

    @NotNull
    @Column(name = "timeEvent", nullable = false)
    private LocalTime timeEvent;

    @NotBlank
    @Column(name = "localEvent", nullable = false, length = 200)
    private String localEvent;

    @Column(name = "createIn", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createIn;
}
