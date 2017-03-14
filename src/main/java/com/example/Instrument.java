package com.example;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "[20170223 xffm2_instruments_structs]")
public class Instrument {

  @Id
  @Column(name = "isoisincod")
  private String isoIsinCod;

  @Column(name = "instshtnam")
  private String instShtNam;
}
