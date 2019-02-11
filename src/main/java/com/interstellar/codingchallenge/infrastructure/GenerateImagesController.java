package com.interstellar.codingchallenge.infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateImagesController {

  @RequestMapping(method = RequestMethod.POST, path = "/generate-images")
  public String name() {
    return "";
  }
}
