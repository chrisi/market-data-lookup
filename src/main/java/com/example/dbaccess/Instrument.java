package com.example.dbaccess;

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

  @Column(name = "description")
  private String desc;
}
