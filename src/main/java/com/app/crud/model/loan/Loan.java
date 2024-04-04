package com.app.crud.model.loan;

import com.app.crud.model.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", nullable = false, unique = true)
    private String ID;

    @Column(name = "dateBorrow", nullable = false)
    private LocalDateTime dateBorrow;

    @Column(name = "dateLimit", nullable = false)
    private LocalDateTime dateLimit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", nullable = false, unique = false)
    private Member member;
}