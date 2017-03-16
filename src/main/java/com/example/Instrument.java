package com.example;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Instrument {

  @Id
  @Column(name = "isin")
  private String isoIsinCod;

  @Column(name = "name")
  private String instShtNam;
}
