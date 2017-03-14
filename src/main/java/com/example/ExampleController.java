package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

  @Autowired
  private InstrumentRepository instrumentRepository;

  @Transactional
  @RequestMapping("/{isin}")
  public Instrument lookup1(@PathVariable("isin") String isin) {
    return instrumentRepository.getOne(isin);
  }

  @Transactional
  @RequestMapping("/lookup")
  public Result lookup2(@RequestParam("isin") String isin) {
    Instrument instrument = instrumentRepository.getOne(isin);
    return new Result(instrument.getIsoIsinCod(), instrument.getInstShtNam());
  }

}

