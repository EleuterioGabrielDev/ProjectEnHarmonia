package br.com.enhmusical.client;

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
    @Column(name = "couples_Name", nullable = false, length = 150)
    private String couplesName;

    @NotBlank
    @Column(length = 11)
    private String phone;

    @NotNull
    @Column(name = "date_Event", nullable = false)
    private LocalDate dateEvent;

    @NotNull
    @Column(name = "time_Event", nullable = false)
    private LocalTime timeEvent;

    @NotBlank
    @Column(name = "local_Event", nullable = false, length = 200)
    private String localEvent;

    @Column(name = "create_In", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createIn;
}
