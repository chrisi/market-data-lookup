package com.example;

import com.example.dbaccess.Document;
import com.example.dbaccess.DocumentRepository;
import com.example.dbaccess.Instrument;
import com.example.dbaccess.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

  @Autowired
  private InstrumentRepository instrumentRepository;

  @Autowired
  private DocumentRepository documentRepository;

  @RequestMapping("/{isin}")
  public Instrument lookup1(@PathVariable("isin") String isin) {
    return instrumentRepository.findOne(isin);
  }

  @RequestMapping("/lookup")
  public Result lookup2(@RequestParam("isin") String isin) {
    Instrument instrument = instrumentRepository.findOne(isin);
    return new Result(instrument.getIsoIsinCod(), instrument.getInstShtNam(), instrument.getDesc());
  }

  @RequestMapping("/doc")
  public ResponseEntity<byte[]> name(@RequestParam("name") String name,
                                     @RequestParam(value = "inline", defaultValue = "true") boolean inline) {
    Document doc = documentRepository.findByName(name);
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    if (!inline) {
      String filename = name.toLowerCase() + ".pdf";
      headers.setContentDispositionFormData(filename, filename);
    }
    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
    return new ResponseEntity<>(doc.getData(), headers, HttpStatus.OK);
  }

}

